package org.StudentManagementSystem.service;

import org.StudentManagementSystem.dto.CreateStudentRequestDTO;
import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.dto.UpdateStudentRequestDTO;
import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.entity.Student;
import org.StudentManagementSystem.mapper.StudentMapper;
import org.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper
                          ) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq) {
        Student student = studentMapper.mapToEntity(studentReq);
        student.setCreateAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        Student studentResp = studentRepository.save(student);
        return studentMapper.mapToDto(studentResp);
    }

    public CreateStudentResponseDTO getStudentById(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentResp.isPresent()) {
            return studentMapper.mapToDto(studentResp.get());
        }
        return null;
    }

    public List<CreateStudentResponseDTO> getAllStudent() {
        List<Student> studentsResp = studentRepository.findByAndDeletedIsFalse();
        List<CreateStudentResponseDTO> stdentList =
                studentsResp.stream().map(m->studentMapper.mapToDto(m)).
                        toList();
        return stdentList;
    }

    public UpdateStudentResponseDTO updateStudentDetails(Long id, UpdateStudentRequestDTO student) {
        Optional<Student> existedStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if (existedStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existedStudent.get();

        studentToSave.setAge(student.getAge());
        studentToSave.setName(student.getName());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return studentMapper.mapToUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudentExist = studentRepository.existsById(id);
        if (!isStudentExist) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existedStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existedStudent.isEmpty()){
            return false;
        }
        Student studentToBeDeleted = existedStudent.get();
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
        return true;

    }

}
