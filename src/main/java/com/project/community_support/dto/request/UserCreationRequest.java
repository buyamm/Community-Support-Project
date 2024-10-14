package com.project.community_support.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {
    private String phoneNumber;
    private String password;
    private String fullName;
    private String cccd;
    private String address;
}
