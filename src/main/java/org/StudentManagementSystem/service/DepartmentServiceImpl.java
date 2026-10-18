package org.StudentManagementSystem.service;

import org.StudentManagementSystem.entity.Department;
import org.StudentManagementSystem.exception.ResourseNotFoundException;
import org.StudentManagementSystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department departmentReq) {
        Department departmentToSave = new Department();
        departmentToSave.setId(departmentReq.getId());
        departmentToSave.setName(departmentReq.getName());
        return departmentRepository.save(departmentToSave);

    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new ResourseNotFoundException("Department with this id does not not exists :" + id)
        );
    }
}
