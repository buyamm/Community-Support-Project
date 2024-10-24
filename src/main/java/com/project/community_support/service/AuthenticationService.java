package com.project.community_support.service;

import com.project.community_support.constant.PredefineRole;
import com.project.community_support.dto.request.AuthenticationRequest;
import com.project.community_support.dto.response.AuthenticationResponse;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.dto.response.UserResponse;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.mapper.OrganizationMapper;
import com.project.community_support.mapper.UserMapper;
import com.project.community_support.repository.OrganizationRepository;
import com.project.community_support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    UserMapper userMapper;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated;

        switch (request.getWhoAreYou()) {
            case PredefineRole.ADMIN_ROLE:
                var organization = organizationRepository.findByPhoneNumber(request.getPhoneNumber())
                        .orElseThrow(
                            () -> new AppException(ErrorCode.USER_NOT_FOUND)
                        );

                authenticated = passwordEncoder.matches(request.getPassword(), organization.getPassword());

                if(authenticated){
                    return AuthenticationResponse.<OrganizationResponse>builder()
                            .result(organizationMapper.toOrganizationResponse(organization))
                            .authenticated(true)
                            .build();
                }
                break;
            case PredefineRole.USER_ROLE:
                var user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                        .orElseThrow(
                                () -> new AppException(ErrorCode.USER_NOT_FOUND)
                        );

                authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

                if(authenticated){
                    return AuthenticationResponse.<UserResponse>builder()
                            .result(userMapper.toUserResponse(user))
                            .authenticated(true)
                            .build();
                }
                break;
        }

        throw new AppException(ErrorCode.WRONG_PASSWORD);
    }
}
