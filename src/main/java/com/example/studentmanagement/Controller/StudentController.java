package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
   private StudentService studentService;

    @GetMapping
    public List<StudentEntity>  allStudent(){
        return studentService.allstudent();
    }

    @PostMapping
    public StudentEntity poststudent(@RequestBody StudentEntity entitydata){
        return studentService.addStudent(entitydata);
    }
}
