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
    @GetMapping
    public ResponseEntity<?> getschool(){
        List<SchoolEntity> s=schoolService.getAllSchool();
        if(s !=null){
            return new ResponseEntity<>(s, HttpStatus.OK);
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
    }
}
