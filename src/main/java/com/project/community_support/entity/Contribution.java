package com.project.community_support.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String content;
    private Instant date;
    private Long amount;

//    @OneToMany(mappedBy = "contribution")
//    private Set<Images> images;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}