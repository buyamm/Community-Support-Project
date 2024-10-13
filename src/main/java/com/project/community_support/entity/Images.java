package com.project.community_support.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String path;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;
}
