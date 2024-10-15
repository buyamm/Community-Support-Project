package com.project.community_support.repository;

import com.project.community_support.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, String> {
}
