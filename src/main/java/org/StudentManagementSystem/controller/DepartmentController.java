package org.StudentManagementSystem.controller;

import org.StudentManagementSystem.entity.Department;
import org.StudentManagementSystem.service.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department departmentReq) {
        Department departmentToCreate = departmentServiceImpl.createDepartment(departmentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentToCreate);
    }

    @GetMapping("/getDepartment/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Department existedDepartment = departmentServiceImpl.getDepartment(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(existedDepartment);
    }
}
