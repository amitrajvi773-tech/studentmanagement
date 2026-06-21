package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Repository.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<SchoolEntity> getAllSchool(){

        return schoolRepository.findAll();
    }

    public SchoolEntity saveNewSchool(SchoolEntity school){
        try{
        school.setPassword(passwordEncoder.encode(school.getPassword()));
        school.setSchoolrole(new ArrayList<>(Arrays.asList("USER")));
         return schoolRepository.save(school);
        }
        catch (Exception e){
            log.error("here in saveNewSchool error",e);
            throw new RuntimeException(
                    "Unable to save school");
      }
    }
    public  SchoolEntity saveSchool(SchoolEntity entry){

        return  schoolRepository.save(entry);
    }

    public SchoolEntity findbyschoolname(@PathVariable String schoolname){

        return  schoolRepository.findBySchoolname(schoolname);

    }

    public Optional<SchoolEntity> getSchoolById(Integer myid) {

        return schoolRepository.findById(myid);
    }

    public void deletebyid(Integer myid) {
        schoolRepository.deleteById(myid);
    }
}
