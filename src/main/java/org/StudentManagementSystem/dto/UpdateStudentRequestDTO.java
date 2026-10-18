package org.StudentManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UpdateStudentRequestDTO {
    private String name;
    private int age;
    private int rollNo;
    private String Subject;

}
