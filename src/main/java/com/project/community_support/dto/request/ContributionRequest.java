package com.project.community_support.dto.request;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContributionRequest {

    private String content;
    private Long amount;
    private Instant date;
    private String formId;
    private String userId;

//    private List<String> images;

}
