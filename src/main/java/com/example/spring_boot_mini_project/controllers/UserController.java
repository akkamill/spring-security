package com.example.spring_boot_mini_project.controllers;

import com.example.spring_boot_mini_project.entities.UserEntity;
import com.example.spring_boot_mini_project.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }








}
