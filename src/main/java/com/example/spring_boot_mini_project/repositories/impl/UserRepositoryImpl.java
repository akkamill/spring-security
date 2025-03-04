//package com.example.spring_boot_mini_project.repositories.impl;
//
//import com.example.spring_boot_mini_project.entities.UserEntity;
//import com.example.spring_boot_mini_project.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserRepositoryImpl {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserRepositoryImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public UserEntity addUser(UserEntity user) {
//        return userRepository.save(user);
//    }
//
//    public List<UserEntity> findAll() {
//        ArrayList<UserEntity> userLists = new ArrayList<>();
//        for(UserEntity user : userRepository.findAll()) {
//            userLists.add(user);
//        }
//        return userLists;
//    }
//
//    public Optional<UserEntity> getUserById(Long userId) {
//        return userRepository.findById(userId);
//    }
//
//    public void deleteUserById(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
////    public UserEntity updateUser(UserEntity user, Long userId) {
////        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()
////                -> new RuntimeException("User not found"));
////        userEntity.setUsername(user.getUsername());
////        userEntity.setAge(user.getAge());
////        userEntity.setEmail(user.getEmail());
////
////        userRepository.save(userEntity);
////
////        return userEntity;
////    }
//
//
//
//}
