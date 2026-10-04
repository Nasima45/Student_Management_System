package org.StudentManagementSystem.mapper;

import org.StudentManagementSystem.dto.CreateStudentRequestDTO;
import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student mapToEntity(CreateStudentRequestDTO studentRequestDto) {
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setSubject(studentRequestDto.getSubject());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setDeleted(false);
        return student;
    }

    public CreateStudentResponseDTO mapToDto(Student student) {
        CreateStudentResponseDTO studentResponseDto = new CreateStudentResponseDTO();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setMessage("Record saved successfully");
        studentResponseDto.setCreateAt(student.getCreateAt());
        studentResponseDto.setUpdatedAt(student.getCreateAt() );
        return studentResponseDto;
    }
    public UpdateStudentResponseDTO mapToUpdateDto(Student student){
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        updateStudentResponseDTO.setRollNo(student.getRollNo());
        updateStudentResponseDTO.setSubject(student.getSubject());
        updateStudentResponseDTO.setMessage("Record Updated Successfully");
        return updateStudentResponseDTO;
    }
}
