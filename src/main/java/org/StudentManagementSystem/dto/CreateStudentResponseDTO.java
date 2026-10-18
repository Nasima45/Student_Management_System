package org.StudentManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateStudentResponseDTO {
    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String Subject;
    private String message;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
