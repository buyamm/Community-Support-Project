package com.project.community_support.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationUpdateRequest {
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
    private String organizationName;
    private String representativeName;
    private String address;
    private String description;
}
