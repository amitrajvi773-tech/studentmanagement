package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

public Optional<StudentEntity> findid(@PathVariable Integer id){
    return studentRepository.findById(id);
}

    public void delete(@PathVariable Integer id) {

    studentRepository.deleteById(id);
    }

    public StudentEntity updatestudent( StudentEntity updatedddata){
    return studentRepository.save(updatedddata);
    }
}


