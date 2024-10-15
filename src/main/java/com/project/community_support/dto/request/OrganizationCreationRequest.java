package com.project.community_support.dto.request;


import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrganizationCreationRequest {
    @Size(min = 10, max = 10, message = "PHONE_NUMBER_INVALID")
    private String phoneNumber;
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
    private String organizationName;
    private String representativeName;
    @Size(min = 12,  max = 12, message = "CCCD_INVALID")
    private String cccd;
    private String address;
    private String description;
}
