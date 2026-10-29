package org.StudentManagementSystem.controller;

import org.StudentManagementSystem.dto.UserRegisterRequestDto;
import org.StudentManagementSystem.dto.UserRegisterResponseDto;
import org.StudentManagementSystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        UserRegisterResponseDto responseDTO = authService.register(registerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }
}
