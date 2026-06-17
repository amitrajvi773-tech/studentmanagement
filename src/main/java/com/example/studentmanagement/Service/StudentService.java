package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Repository.SchoolRepository;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
@Autowired
    StudentRepository studentRepository;
@Autowired
SchoolService schoolService;

@Autowired
    SchoolRepository schoolRepository;


public List<StudentEntity> getAll(){

    return studentRepository.findAll();
}
public void  addStudent(StudentEntity entitydata,String schoolname){
    SchoolEntity school=schoolService.findbyschoolname(schoolname);
   StudentEntity savestudent= studentRepository.save(entitydata);
   school.getStudents().add(savestudent);
   schoolService.saveNewSchool(school);

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
//
}


