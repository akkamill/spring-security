package com.example.spring_boot_mini_project.services.impl;

import com.example.spring_boot_mini_project.entities.UserEntity;
import com.example.spring_boot_mini_project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }


    public List<UserEntity> findAll() {
        ArrayList<UserEntity> userLists = new ArrayList<>();
        for (UserEntity user : userRepository.findAll()) {
            userLists.add(user);
        }
        return userLists;
    }

    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}