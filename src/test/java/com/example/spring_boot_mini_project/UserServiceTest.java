package com.example.spring_boot_mini_project;

import com.example.spring_boot_mini_project.entities.UserEntity;
import com.example.spring_boot_mini_project.repositories.UserRepository;
import com.example.spring_boot_mini_project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser() {
        UserEntity user = new UserEntity();
        user.setUsername("John Doe");
        user.setEmail("john@example.com");

//        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity createdUser = userService.addUser(user);

        assertEquals("John Doe", createdUser.getUsername());
        assertEquals("john@example.com", createdUser.getEmail());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void testGetUserById_UserExists() {
        UserEntity user = new UserEntity();
        user.setUserId(1L);
        user.setUsername("John Doe");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserEntity> foundUser = userService.getUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals(1L, foundUser.get().getUserId());
        assertEquals("John Doe", foundUser.get().getUsername());
    }

    @Test
    void testGetUserById_UserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(1L).orElseThrow(NoSuchElementException::new);
        });
    }


    @Test
    void testGetAllUsers() {
        List<UserEntity> users = Arrays.asList(new UserEntity(), new UserEntity());
        when(userRepository.findAll()).thenReturn(users);

        List<UserEntity> result = userService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUserById(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}
