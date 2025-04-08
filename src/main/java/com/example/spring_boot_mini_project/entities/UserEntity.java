package com.example.spring_boot_mini_project.entities;


import com.example.spring_boot_mini_project.entities.security.AuthToken;
import com.example.spring_boot_mini_project.entities.security.RoleEntity;
import jakarta.persistence.*;
import lombok.*;


import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "users_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuthToken> tokens = new ArrayList<>();

}
