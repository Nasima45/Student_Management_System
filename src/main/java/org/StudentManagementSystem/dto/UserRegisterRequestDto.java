package org.StudentManagementSystem.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRegisterRequestDto {
    private String userName;
    private String password;
}
