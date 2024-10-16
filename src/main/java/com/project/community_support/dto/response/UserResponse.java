package com.project.community_support.dto.response;


import com.project.community_support.entity.Form;
import lombok.*;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String phoneNumber;
    private String password;
    private String fullName;
    private String cccd;
    private String address;
    private Set<Form> forms;
}
