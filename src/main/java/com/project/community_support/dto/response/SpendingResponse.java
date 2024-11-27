package com.project.community_support.dto.response;


import lombok.*;


import java.time.Instant;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpendingResponse {
    private String content;
    private Instant date;
    private Long amount;
    private Map<String, Object> form = new HashMap<>();
}
