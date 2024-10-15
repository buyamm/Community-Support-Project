package com.project.community_support.dto.request;


import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {
    @Size(min = 10, max = 10, message = "PHONE_NUMBER_INVALID")
    private String phoneNumber;
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
    private String fullName;
    @Size(min = 12, max = 12, message = "CCCD_INVALID")
    private String cccd;
    private String address;
}
