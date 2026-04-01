package com.kingsly.ai_platform.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private String responseMsg;
    private int responseCode;
    private LocalDateTime currentTime;
    private T body;
}
