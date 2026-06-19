package com.example.studentmanagement.Controller;

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
    private SchoolService  schoolService;




    @GetMapping("/{schoolname}")
    public ResponseEntity<?>  getAllStudentFromSchool(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name=authentication.getName();
        SchoolEntity school=schoolService.findbyschoolname(name);
        List<StudentEntity> student=school.getStudentEntries();
        if(school == null){
            return ResponseEntity.notFound().build();
        }

            return new ResponseEntity<>(student,HttpStatus.OK);

    }

    @PostMapping("/{schoolname}")
    public ResponseEntity<?> poststudent(@Valid @RequestBody StudentEntity entitydata ){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String schoolname=authentication.getName();
        try{
            studentService.saveStudent(entitydata,schoolname);
        return new ResponseEntity<>(entitydata,HttpStatus.CREATED);}
      catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }



    @GetMapping("/id/{myid}")
    public Optional<StudentEntity> findById(@PathVariable Integer myid){
            return studentService.findStudentById(myid);}

    @DeleteMapping("/id/{myid}")
    public void deletebyid(@PathVariable Integer myid){
         studentService.deleteStundent(myid);
    }


    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updatastudent(@RequestBody StudentEntity entitydata, @PathVariable Integer myid) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String schoolname=authentication.getName();

        StudentEntity existingstudent = studentService.fin.orElse(null);
           if(existingstudent == null){
               return ResponseEntity.notFound().build();
           }
            existingstudent.setStudentname(entitydata.getStudentname());
            existingstudent.setEmail(entitydata.getEmail());
            existingstudent.setBranch(entitydata.getBranch());


        return new ResponseEntity<>(studentService.updateStudent(existingstudent), HttpStatus.OK);


    }



}
