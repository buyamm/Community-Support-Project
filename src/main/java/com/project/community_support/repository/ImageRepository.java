package com.project.community_support.repository;

import com.project.community_support.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository<Images, String> {
}
