package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    Optional<StudentEntity> findByStudentname(String studentname);
}
