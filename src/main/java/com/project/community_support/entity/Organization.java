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
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String password;
    private String representativeName;
    private String phoneNumber;
    private String organizationName;
    private String cccd;
    private String address;
    private String description;
    private String roleName;

    @OneToMany(mappedBy = "organization")
    private Set<Form> forms;
}
