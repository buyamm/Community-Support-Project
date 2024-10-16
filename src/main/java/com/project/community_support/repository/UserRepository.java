package com.project.community_support.repository;

import com.project.community_support.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByCccd(String cccd);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
