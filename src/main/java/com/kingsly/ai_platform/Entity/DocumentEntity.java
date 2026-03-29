package com.kingsly.ai_platform.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="documents")
@Data
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(name="file_path")
    private String filePath;
    @ManyToOne
    @JoinColumn(name="uploaded_by")
    private UserEntity uploadedBy;
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void berforeInsert(){
        this.createdAt=LocalDateTime.now();
    }
}
