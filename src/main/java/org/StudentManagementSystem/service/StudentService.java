package org.StudentManagementSystem.service;

import org.StudentManagementSystem.entity.Student;
import org.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        Student studentRepo = studentRepository.save(studentReq);
        return studentRepo;
    }

    public Student getStudentById(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentsResp = studentRepository.findAll();
        return studentsResp;
    }

    public Student updateStudentDetails(Long id, Student student) {
        Optional<Student> existedStudent = studentRepository.findById(id);
        if (existedStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existedStudent.get();

        studentToSave.setAge(student.getAge());
        studentToSave.setName(student.getName());
        studentToSave.setEmail(student.getEmail());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setRollNo(student.getRollNo());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudentExist = studentRepository.existsById(id);
        if (!isStudentExist) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }


}
