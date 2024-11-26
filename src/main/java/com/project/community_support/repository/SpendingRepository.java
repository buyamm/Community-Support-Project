package com.project.community_support.repository;

import com.project.community_support.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingRepository extends JpaRepository<Spending, String> {
    Spending findByFormId(String formId);
}
