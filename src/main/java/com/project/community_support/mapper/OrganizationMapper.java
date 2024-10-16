package com.project.community_support.mapper;

import com.project.community_support.dto.request.OrganizationCreationRequest;
import com.project.community_support.dto.request.OrganizationUpdateRequest;
import com.project.community_support.dto.response.OrganizationResponse;
import com.project.community_support.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    Organization toOrganization(OrganizationCreationRequest request);

    OrganizationResponse toOrganizationResponse(Organization organization);

    void updateOrganization(@MappingTarget Organization organization, OrganizationUpdateRequest organizationUpdateRequest);
}
