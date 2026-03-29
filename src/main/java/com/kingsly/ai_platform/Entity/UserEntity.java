package com.kingsly.ai_platform.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    private String role;
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void berforeInsert(){
        this.createdAt=LocalDateTime.now();
    }
}
