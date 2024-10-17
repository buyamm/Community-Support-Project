package com.project.community_support.dto.response;

import lombok.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormResponse {

    private String phoneNumber;
    private String address;
    private String description;
    private Long target;
    private Instant deadline;
    private Instant dateOfApplication;
    private Map<String, Object> organization = new HashMap<>();
    private Map<String, Object> user = new HashMap<>();
    private boolean isTemp;
    private List<String> images;
}

