package org.StudentManagementSystem.controller;

import jakarta.validation.Valid;
import org.StudentManagementSystem.dto.CreateStudentRequestDTO;
import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.dto.UpdateStudentRequestDTO;
import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.entity.Student;
import org.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO student) {
        CreateStudentResponseDTO createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudentById(@PathVariable Long id) {
        CreateStudentResponseDTO studentResp = studentService.getStudentById(id);
        if (studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent() {
        List<CreateStudentResponseDTO> studentResp = studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequestDTO student) {
        UpdateStudentResponseDTO studentResp = studentService.updateStudentDetails(id, student);
        if (studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");

    }
    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Record removed");
    }
}
