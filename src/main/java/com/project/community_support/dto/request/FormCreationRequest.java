package com.project.community_support.dto.request;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormCreationRequest {
    private String phoneNumber;
    private String address;
    private String description;
    private Long target;
    private Instant deadline;
    private String organizationId;
    private String userId;
    boolean isTemp;
    private List<String> images;
}