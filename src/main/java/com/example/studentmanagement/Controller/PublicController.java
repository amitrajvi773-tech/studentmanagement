package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/public")
public class PublicController {
    @Autowired
    private SchoolService schoolService;
    @PostMapping
    public ResponseEntity<?> postSchool(@RequestBody SchoolEntity entry){

        if(entry != null){

            SchoolEntity savedSchool = schoolService.saveNewSchool(entry);

            return new ResponseEntity<>(savedSchool, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
