package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
@Autowired
    StudentRepository studentRepository;


public List<StudentEntity> allstudent(){
    return studentRepository.findAll();
}
public StudentEntity addStudent(StudentEntity entitydata){
return studentRepository.save(entitydata);
}
}


