package com.chat2.chat2.ApiResponse;

import java.time.LocalDateTime;

public class ApiSuccessResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private T data;

    public ApiSuccessResponse(int status, String error, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.data = data;
    }

    // Getters and setters omitted for brevity
}