package org.StudentManagementSystem.service;

import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.dto.UserRegisterRequestDto;
import org.StudentManagementSystem.dto.UserRegisterResponseDto;
import org.StudentManagementSystem.entity.User;
import org.StudentManagementSystem.mapper.RegisterMapper;
import org.StudentManagementSystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RegisterMapper registerMapper;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RegisterMapper registerMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.registerMapper = registerMapper;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto ){
        User user = registerMapper.mapToEntity(registerRequestDto);
        userRepository.save(user);
        UserRegisterResponseDto responseDTO = registerMapper.mapToDto(user);
        return responseDTO;

    }
}
