package org.StudentManagementSystem.service;

import org.StudentManagementSystem.annotation.TrackExecutionTime;
import org.StudentManagementSystem.dto.CreateStudentRequestDTO;
import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.dto.UpdateStudentRequestDTO;
import org.StudentManagementSystem.dto.UpdateStudentResponseDTO;
import org.StudentManagementSystem.entity.Department;
import org.StudentManagementSystem.entity.Student;
import org.StudentManagementSystem.exception.DuplicateResourseException;
import org.StudentManagementSystem.exception.ResourseNotFoundException;
import org.StudentManagementSystem.mapper.StudentMapper;
import org.StudentManagementSystem.repository.DepartmentRepository;
import org.StudentManagementSystem.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private DepartmentRepository departmentRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper,
                              DepartmentRepository departmentRepository)
    {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.departmentRepository = departmentRepository;
    }
    @TrackExecutionTime(warnAfter = 1000)
    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq) {
        //Department department = departmentRepository.getDepartment(departmentId)
        logger.info("Students details need to be save {}",studentReq);
        Student student = studentMapper.mapToEntity(studentReq);
        if (emailExists(student)) {
            throw new DuplicateResourseException(studentReq.getEmail() + " is already exists in our db");
        }
        Student studentResp = studentRepository.save(student);
        logger.info("{} saved in our db", studentResp);
        return studentMapper.mapToDto(studentResp);
    }
    @TrackExecutionTime
    public CreateStudentResponseDTO getStudentById(Long id) {
        Student studentResp = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourseNotFoundException("Resource " + id + " not found"));
        return studentMapper.mapToDto(studentResp);
    }

    public List<CreateStudentResponseDTO> getAllStudent() {
        //Pageable page = (Pageable) PageRequest.of(0,2);
        List<Student> studentsResp = studentRepository.findByAndDeletedIsFalse();
        List<CreateStudentResponseDTO> stdentList =
                studentsResp.stream().map(m -> studentMapper.mapToDto(m)).
                        toList();
        return stdentList;
    }

    public UpdateStudentResponseDTO updateStudentDetails(Long id, UpdateStudentRequestDTO student) {
        Student studentToSave = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourseNotFoundException(
                        id + " This resource you are trying o update not present in our db "));

        studentToSave.setAge(student.getAge());
        studentToSave.setName(student.getName());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return studentMapper.mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException(id + " id is not present in db"));
        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourseNotFoundException(id + " not exists in db"));
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }

}
