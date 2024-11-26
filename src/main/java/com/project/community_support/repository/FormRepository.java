package com.project.community_support.repository;

import com.project.community_support.dto.response.FormResponse;
import com.project.community_support.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, String> {
    List<Form> findByOrganizationId(String organizationId);
}
