package com.project.community_support.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponse {
    private String accountHolder;
    private String accountNumber;
    private String bankName;
    private String transferContent;
}

