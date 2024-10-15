package com.project.community_support.service;

import com.project.community_support.dto.request.OrganizationCreationRequest;
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

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        Organization organization = organizationMapper.toOrganization(request);
        organization.setPassword(passwordEncoder.encode(request.getPassword()));

        return organizationMapper.toOrganizationResponse(organizationRepository.save(organization));
    }
}
