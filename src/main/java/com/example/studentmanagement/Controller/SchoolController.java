package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @GetMapping
    public ResponseEntity<?> get(){
        SchoolEntity s=schoolService.getAll();
        if(s !=null){
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
