package org.StudentManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionDTO {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
}
