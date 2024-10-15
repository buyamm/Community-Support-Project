package com.project.community_support.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationResponse {
    private String phoneNumber;
    private String password;
    private String organizationName;
    private String representativeName;
    private String cccd;
    private String address;
    private String description;
}
