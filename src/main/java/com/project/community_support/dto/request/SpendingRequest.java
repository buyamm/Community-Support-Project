package com.project.community_support.dto.request;

import com.project.community_support.entity.Form;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpendingRequest {
    private String content;
    private Instant date;
    private Long amount;
}
