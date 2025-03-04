package com.example.spring_boot_mini_project.controllers;

import com.example.spring_boot_mini_project.entities.UserEntity;
import com.example.spring_boot_mini_project.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }








}
