package com.chat2.chat2.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private List<ValidationError> errors;

    public ApiErrorResponse(int status, String message, List<ValidationError> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    // Getters and setters omitted for brevity

    public static class ValidationError {
        private String field;
        private String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        // Getters and setters omitted for brevity
    }
}