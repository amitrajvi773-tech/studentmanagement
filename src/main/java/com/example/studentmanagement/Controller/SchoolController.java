package com.example.studentmanagement.Controller;

import com.example.studentmanagement.DTO.SchoolGetDTO;
import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;



//    @GetMapping()
//    public ResponseEntity<?> getallstudentofschool(){
//
//        List<SchoolEntity> s=schoolService.getAllSchool();
//        if(s !=null){
//            return new ResponseEntity<>(s, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }

    @GetMapping()
    public SchoolGetDTO getSchool() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        SchoolEntity school = schoolService.findbyschoolname(username);

        SchoolGetDTO schoolGetDTO=new SchoolGetDTO();
        schoolGetDTO.setSchoolname(school.getSchoolname());
        schoolGetDTO.setStudentEntries(school.getStudentEntries());
        return schoolGetDTO;
    } 

    @DeleteMapping("id/{myid}")
    public void deleteById(@PathVariable Integer myid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        schoolService.deletebyid(myid);
    }

    @PutMapping
    public ResponseEntity<?> updateSchool(@RequestBody SchoolEntity entry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            String schoolname=authentication.getName();
        SchoolEntity updated=schoolService.findbyschoolname(schoolname);
        if(updated==null) {
            throw new IllegalArgumentException("your entry has issue");
        }
        updated.setSchoolname(entry.getSchoolname());
        updated.setPassword(entry.getPassword());

        schoolService.saveSchool(updated);
        return new ResponseEntity<>(HttpStatus.OK);



    }}



