package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @GetMapping()
    public ResponseEntity<?> getallstudentofschool(){

        List<SchoolEntity> s=schoolService.getAllSchool();
        if(s !=null){
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }



    @GetMapping("/id/{myid}")
    public Optional<SchoolEntity> getSchollById(@PathVariable Integer myid) {
        return schoolService.getSchoolById(myid);
    }

    @DeleteMapping("id/{myid}")
    public void deleteById(@PathVariable Integer myid){
        schoolService.deletebyid(myid);
    }


}
