package org.StudentManagementSystem.service;

import org.StudentManagementSystem.entity.Role;
import org.StudentManagementSystem.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }
    public void addRoll(Role role){
        repository.save(role);
    }
}
