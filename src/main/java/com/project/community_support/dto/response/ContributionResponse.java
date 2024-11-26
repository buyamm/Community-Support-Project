package com.project.community_support.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ContributionResponse {

    private String id;
    private String content;
    private Long amount;
    private Instant date;
    private Map<String, Object> form = new HashMap<>();
    private UserResponse userResponse;
//    private List<String> images;
}
