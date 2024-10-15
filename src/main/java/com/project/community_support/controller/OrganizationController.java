package com.project.community_support.controller;


import com.project.community_support.dto.request.OrganizationCreationRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    ApiResponse<OrganizationResponse> createOrganization(@RequestBody @Valid OrganizationCreationRequest request){
        return ApiResponse.<OrganizationResponse>builder()
                .result(organizationService.createOrganization(request))
                .build();
    }
}
