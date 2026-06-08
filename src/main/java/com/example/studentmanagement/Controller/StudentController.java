package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.SchoolService;
import com.example.studentmanagement.Service.StudentService;
import jakarta.validation.Valid;
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
    private SchoolService  schoolService;

    @GetMapping
    public List<StudentEntity> getAllStudent(){
        return studentService.getAll();
    }

    @GetMapping("/{schoolname}")
    public ResponseEntity<?>  getAllStudentFromSchool(@PathVariable String schoolname){
        SchoolEntity school=schoolService.findbyschoolname(schoolname);
        if(school == null){
            return ResponseEntity.notFound().build();
        }
        List<StudentEntity> all=school.getStudents();
        if(all!=null){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{schoolname}")
    public ResponseEntity<?> poststudent(@Valid @RequestBody StudentEntity entitydata, @PathVariable String schoolname ){

        try{  studentService.addStudent(entitydata,schoolname);
        return new ResponseEntity<>(entitydata,HttpStatus.CREATED);}
      catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

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
