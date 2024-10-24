package com.project.community_support.service;

import com.project.community_support.constant.PredefineRole;
import com.project.community_support.dto.request.OrganizationCreationRequest;
import com.project.community_support.dto.request.OrganizationUpdateRequest;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.entity.Organization;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.mapper.OrganizationMapper;
import com.project.community_support.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationMapper organizationMapper;

    public OrganizationResponse createOrganization(OrganizationCreationRequest request) {
        if (organizationRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        if (organizationRepository.existsByCccd(request.getCccd())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        Organization organization = organizationMapper.toOrganization(request);
        organization.setPassword(passwordEncoder.encode(request.getPassword()));
        organization.setRoleName(PredefineRole.ADMIN_ROLE);

        return organizationMapper.toOrganizationResponse(organizationRepository.save(organization));
    }

    public List<OrganizationResponse> getAllOrganizations() {
        return organizationRepository.findAll().stream().map(organization -> organizationMapper.toOrganizationResponse(organization)).toList();
    }

    public OrganizationResponse getOrganization(String organizationId) {
        return organizationMapper.toOrganizationResponse(organizationRepository.findById(organizationId).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        ));
    }

    public OrganizationResponse updateOrganization(OrganizationUpdateRequest request, String organizationId) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        );

        organizationMapper.updateOrganization(organization, request);

        return organizationMapper.toOrganizationResponse(organization);
    }

    public void deleteOrganization(String organizationId){
        organizationRepository.deleteById(organizationId);
    }
}
