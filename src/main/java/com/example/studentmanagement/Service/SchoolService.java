package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<SchoolEntity> getAllSchool(){

        return schoolRepository.findAll();
    }
      public void saveSchool(SchoolEntity school){

}
    public  SchoolEntity saveNewSchool(SchoolEntity entry){
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
