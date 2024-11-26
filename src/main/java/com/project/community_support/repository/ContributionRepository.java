package com.project.community_support.repository;

import com.project.community_support.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, String> {
    List<Contribution> findByFormId(String formId);
}
