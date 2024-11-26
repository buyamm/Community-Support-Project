package com.project.community_support.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String description;
    private Long target;
    private Instant deadline;
    @CreationTimestamp
    private Instant dateOfApplication;
//    private String accountHolder;
//    private String accountNumber;
//    private String bankName;
//    private String transferContent;
    private boolean isTemp;
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "form")
    private Set<Images> images;


    @OneToOne
    @JoinColumn(name = "bankAccount_id")
    private BankAccount bankAccount;

    @OneToOne
    @JoinColumn(name = "spending_id")
    private Spending spending;

    @OneToMany(mappedBy = "form")
    private Set<Contribution> contributions;

}
