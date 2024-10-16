package com.project.community_support.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {
    private String phoneNumber;
    private String password;
    private String whoAreYou;
}
