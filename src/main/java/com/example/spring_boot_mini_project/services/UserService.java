package com.example.spring_boot_mini_project.services;

import com.example.spring_boot_mini_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserEntity addUser(UserEntity user);
    List<UserEntity> findAll();
    Optional<UserEntity> getUserById(Long userId);
    void deleteUserById(Long userId);
}
