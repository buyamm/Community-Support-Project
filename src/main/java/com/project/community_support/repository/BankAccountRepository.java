package com.project.community_support.repository;

import com.project.community_support.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String > {
}
