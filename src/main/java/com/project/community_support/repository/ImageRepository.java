package com.project.community_support.repository;

import com.project.community_support.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface ImageRepository extends JpaRepository<Images, String> {
    List<Images> findAllByFormId(String formId);
}
