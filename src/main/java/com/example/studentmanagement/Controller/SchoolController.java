package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public SchoolEntity getSchollById(@PathVariable Integer myid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        return schoolService.findbyschoolname(username);
    } 

    @DeleteMapping("id/{myid}")
    public void deleteById(@PathVariable Integer myid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        schoolService.deletebyid(myid);
    }

    @PutMapping
    public ResponseEntity<?> updateSchool(@RequestBody SchoolEntity entry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            String schoolname=authentication.getName();
        SchoolEntity updated=schoolService.findbyschoolname(schoolname);
        updated.setSchoolname(entry.getSchoolname());
        updated.setPassword(entry.getPassword());

        schoolService.saveSchool(updated);
        return new ResponseEntity<>(HttpStatus.OK);


        } catch (Exception e) {
            log.error("THERE IS ERROR IN YOUR PUTAPI",e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }


}
