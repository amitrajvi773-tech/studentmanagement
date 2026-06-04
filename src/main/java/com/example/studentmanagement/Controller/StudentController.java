package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.SchoolService;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    public List<StudentEntity>  allStudent(){

        return studentService.allstudent();
    }

    @PostMapping("school/{myid}")
    public StudentEntity poststudent(@RequestBody StudentEntity entitydata,@PathVariable Integer myid){
        return studentService.addStudent(entitydata);

    }



    @GetMapping("/id/{myid}")
    public Optional<StudentEntity> findById(@PathVariable Integer myid){
            return studentService.findid(myid);}

    @DeleteMapping("/id/{myid}")
    public void deletebyid(@PathVariable Integer myid){
         studentService.delete(myid);
    }


    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updatastudent(@RequestBody StudentEntity entitydata, @PathVariable Integer myid) {
        StudentEntity existingstudent = studentService.findid(myid).orElse(null);
           if(existingstudent == null){
               return ResponseEntity.notFound().build();
           }
            existingstudent.setStudentname(entitydata.getStudentname());
            existingstudent.setEmail(entitydata.getEmail());
            existingstudent.setBranch(entitydata.getBranch());


        return new ResponseEntity<>(studentService.updatestudent(existingstudent), HttpStatus.OK);


    }



}
