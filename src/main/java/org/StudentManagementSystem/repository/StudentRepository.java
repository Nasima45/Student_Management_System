package org.StudentManagementSystem.repository;

import org.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);
    List<Student > findByAndDeletedIsFalse();
    Boolean existsByEmail(String email);


}
