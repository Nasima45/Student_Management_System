package org.StudentManagementSystem.service;

import org.StudentManagementSystem.entity.Department;

public interface DepartmentService {
    Department createDepartment(Department departmentReq);

    Department getDepartment(Long id);
}
