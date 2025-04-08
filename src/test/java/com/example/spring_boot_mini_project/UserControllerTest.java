package com.example.spring_boot_mini_project;

import com.example.spring_boot_mini_project.controllers.UserController;
import com.example.spring_boot_mini_project.entities.UserEntity;
import com.example.spring_boot_mini_project.services.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock 
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setUsername("John Doe");
        user.setEmail("john@example.com");

        when(userService.addUser(any(UserEntity.class))).thenReturn(user);

        mockMvc.perform(post("/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\", \"email\": \"john@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

//    @Test
//    void testGetUserById() throws Exception {
//        UserEntity user = new UserEntity();
//        user.setUserId(1L);
//        user.setUsername("John Doe");
//
//        when(userService.getUserById(1L)).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/users/1"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.name").value("John Doe"));
//    }

    @Test
    void testGetAllUsers() throws Exception {
        List<UserEntity> users = Arrays.asList(new UserEntity(), new UserEntity());
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.length()").value(2));
    }
}
