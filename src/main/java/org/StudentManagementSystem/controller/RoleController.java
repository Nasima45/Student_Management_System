package org.StudentManagementSystem.controller;

import org.StudentManagementSystem.entity.Role;
import org.StudentManagementSystem.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/createRoll")
    public ResponseEntity<String> addRole(@RequestBody Role role) {
        roleService.addRoll(role);
        return ResponseEntity.ok("Role added");
    }
}
