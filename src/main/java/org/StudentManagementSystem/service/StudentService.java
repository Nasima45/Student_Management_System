package org.StudentManagementSystem.service;

import org.StudentManagementSystem.dto.CreateStudentRequestDTO;
import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.dto.UpdateStudentRequestDTO;
import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;

import java.util.List;

public interface StudentService {
    CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq);

    CreateStudentResponseDTO getStudentById(Long id);

    List<CreateStudentResponseDTO> getAllStudent();

    UpdateStudentResponseDTO updateStudentDetails(Long id, UpdateStudentRequestDTO student);

    void deleteStudent(Long id);

    void deleteStudentSoftly(Long id);
}
