package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @GetMapping("/{schoolname}")
    public ResponseEntity<?> getallstudentofschool(@PathVariable String schoolname ){
        SchoolEntity school=schoolService.findbyschoolname(schoolname);

        List<StudentEntity> all=school.getStudents();
        if(all !=null){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<?> postSchool(@RequestBody SchoolEntity entry){
        if(entry !=null){
            schoolService.addSchool(entry);
        }
        else {
            System.out.println("wrong entry");
        }
        return  null;
    }
}
