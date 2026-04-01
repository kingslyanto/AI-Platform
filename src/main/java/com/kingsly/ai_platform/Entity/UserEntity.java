package com.kingsly.ai_platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message="Name is required")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message="Password is required")
    private String password;
    private String role;
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void berforeInsert(){
        this.createdAt=LocalDateTime.now();
    }
}
