package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Repository.SchoolRepository;
import com.example.studentmanagement.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Slf4j
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

public void saveStudent(StudentEntity entitydata, String schoolname){

    SchoolEntity school=schoolService.findbyschoolname(schoolname);
   StudentEntity savestudent= studentRepository.save(entitydata);
   try{
       if(savestudent != null){
   school.getStudentEntries().add(savestudent);
   schoolService.saveSchool(school);}}
   catch (Exception e) {
       throw new RuntimeException(e);
   }

}

public Optional<StudentEntity> findStudentById(@PathVariable Integer id){

    return studentRepository.findById(id);

}
public Optional<StudentEntity> findStudentByName(@PathVariable String username){

        return studentRepository.findByStudentname(username);

    }


    public void deleteStundent(@PathVariable Integer id,String schoolname) {
    try {
        SchoolEntity stud=schoolService.findbyschoolname(schoolname);
        boolean removed=stud.getStudentEntries().removeIf(x->x.getId().equals(id));
        if(removed){
              schoolRepository.save(stud);
              studentRepository.deleteById(id);
                  }
              }
    catch (Exception e) {
        log.error("this is error in deletion service ",e);
    }


    }

    public StudentEntity updateStudent(StudentEntity updatedddata,String schoolname){
    

    return studentRepository.save(updatedddata);

    }

}


