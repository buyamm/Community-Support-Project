package com.project.community_support.dto.response;

import com.project.community_support.entity.Form;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Any;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

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
