package com.example.spring_boot_mini_project.repositories;

import com.example.spring_boot_mini_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    UserEntity findByUsername(String username);


}
