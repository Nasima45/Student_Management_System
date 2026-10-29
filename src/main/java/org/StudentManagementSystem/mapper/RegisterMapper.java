package org.StudentManagementSystem.mapper;

import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.dto.UserRegisterRequestDto;
import org.StudentManagementSystem.dto.UserRegisterResponseDto;
import org.StudentManagementSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User mapToEntity(UserRegisterRequestDto registerRequestDto){
        User user = new User();
        user.setUserName(registerRequestDto.getUserName());
        String encodedPasword = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodedPasword);
        return user;
    }
    public UserRegisterResponseDto mapToDto(User user){
        UserRegisterResponseDto registerResponseDto = new UserRegisterResponseDto();
        registerResponseDto.setUserName(user.getUserName());
        registerResponseDto.setMessage("User details saved successfully");
        return registerResponseDto;
    }
}
