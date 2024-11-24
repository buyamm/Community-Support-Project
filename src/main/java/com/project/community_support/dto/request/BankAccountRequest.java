package com.project.community_support.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequest {
    private String accountHolder;
    private String accountNumber;
    private String bankName;
    private String transferContent;
}
