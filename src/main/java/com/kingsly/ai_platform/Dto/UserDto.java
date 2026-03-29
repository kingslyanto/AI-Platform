package com.kingsly.ai_platform.Dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;
    private String status;
}
