package com.example.studentmanagement.Controller;

import com.example.studentmanagement.DTO.StudentPostDTO;
import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.SchoolService;
import com.example.studentmanagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<?> getAllStudentFromSchool() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        SchoolEntity school = schoolService.findbyschoolname(name);
        List<StudentEntity> student = school.getStudentEntries();
        if (school == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> poststudent(@Valid @RequestBody StudentPostDTO entitydata) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String schoolname = authentication.getName();
        try {
            
            studentService.saveStudent(entitydata, schoolname);
            return new ResponseEntity<>(entitydata, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);        }

    }


    @GetMapping("/id/{myid}")
    public Optional<StudentEntity> findById(@PathVariable Integer myid) {
        return studentService.findStudentById(myid);
    }

    @DeleteMapping("/id/{myid}")
    public boolean deletebyid(@PathVariable Integer myid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String schoolname = authentication.getName();
        studentService.deleteStundent(myid, schoolname);
        return true;
    }


    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updatastudent(@RequestBody StudentEntity myentry, @PathVariable Integer myid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String schoolname = authentication.getName();
        SchoolEntity existingstudent = schoolService.findbyschoolname(schoolname);
        if(existingstudent == null){
            return ResponseEntity.notFound().build();
        }

        StudentEntity checking = existingstudent.getStudentEntries().stream().filter(x -> x.getId().equals(myid)).findFirst().orElse(null);
        
        if (checking != null) {
            StudentEntity old = checking;

            old.setStudentname(myentry.getStudentname() != null && !myentry.getStudentname().isEmpty() ? myentry.getStudentname() : old.getStudentname());
            old.setEmail(myentry.getEmail() != null && !myentry.getEmail().isEmpty() ? myentry.getEmail() : old.getEmail());
            old.setBranch(myentry.getBranch() != null && !myentry.getBranch().isEmpty() ? myentry.getBranch() : old.getBranch());

            return new ResponseEntity<>(studentService.updateStudent(old, schoolname), HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }
}