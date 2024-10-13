package com.project.community_support.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String phoneNumber;
    private String password;
    private String fullName;
    private String cccd;
    private String address;

    @OneToMany(mappedBy = "user")
    private Set<Form> forms;
}
