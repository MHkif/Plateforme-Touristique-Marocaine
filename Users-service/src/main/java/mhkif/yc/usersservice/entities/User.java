package mhkif.yc.usersservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import mhkif.yc.usersservice.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime registeredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
