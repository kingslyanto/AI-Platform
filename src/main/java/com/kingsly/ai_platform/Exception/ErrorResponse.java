package com.kingsly.ai_platform.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private String errorMsg;
    private int errorCode;
    private LocalDateTime currentTime;
    private Map<String, String> errors;

    public ErrorResponse(String message, int status, LocalDateTime timestamp) {
        this.errorMsg = message;
        this.errorCode = status;
        this.currentTime = timestamp;
    }

    public ErrorResponse(String message, int status, LocalDateTime timestamp, Map<String, String> errors) {
        this.errorMsg = message;
        this.errorCode = status;
        this.currentTime = timestamp;
        this.errors = errors;
    }
}
