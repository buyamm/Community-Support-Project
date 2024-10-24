package com.project.community_support.controller;


import com.project.community_support.dto.request.OrganizationCreationRequest;
import com.project.community_support.dto.request.OrganizationUpdateRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping
    ApiResponse<List<OrganizationResponse>> getAllOrganizations(){
        return ApiResponse.<List<OrganizationResponse>>builder()
                .result(organizationService.getAllOrganizations())
                .build();
    }

    @GetMapping("/{organizationId}")
    ApiResponse<OrganizationResponse> getOrganization(@PathVariable("organizationId") String organizationId){
        return ApiResponse.<OrganizationResponse>builder()
                .result(organizationService.getOrganization(organizationId))
                .build();
    }

    @PutMapping("/{organizationId}")
    ApiResponse<OrganizationResponse> updateOrganization(@RequestBody @Valid OrganizationUpdateRequest request, @PathVariable("organizationId") String organizationId){
        return ApiResponse.<OrganizationResponse>builder()
                .result(organizationService.updateOrganization(request, organizationId))
                .build();
    }

    @DeleteMapping("/{organizationId}")
    ApiResponse<String> deleteOrganization(@PathVariable("organizationId") String organizationId){
        organizationService.deleteOrganization(organizationId);
        return ApiResponse.<String>builder()
                .result("Organization has been deleted")
                .build();
    }
}
