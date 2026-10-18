package org.StudentManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateStudentRequestDTO {
    @NotBlank(message = "You forget to put name ")
    private String name;
    @Min(value = 18)
    private int age;
    @Email
    private String email;
    private int rollNo;
    private String Subject;
}
