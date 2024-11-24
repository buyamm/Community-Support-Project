package com.project.community_support.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String accountHolder;
    private String accountNumber;
    private String bankName;
    private String transferContent;

    @OneToOne
    @JoinColumn(name = "form_id" )
    private Form form;
}
