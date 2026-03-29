package com.kingsly.ai_platform.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "queries")
@Data
public class QueryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @Column(columnDefinition = "TEXT")
    private String response;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void berforeInsert() {
        this.createdAt = LocalDateTime.now();
    }
}
