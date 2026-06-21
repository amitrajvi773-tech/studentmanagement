package com.example.studentmanagement;

import com.example.studentmanagement.Repository.SchoolRepository;
import com.example.studentmanagement.Service.SchoolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SchoolServiceTest {
    @Autowired
    SchoolService schoolService;

    @Test
    public void  schoolTest(){
        schoolService.getAllSchool();

    }

    @ParameterizedTest
    @CsvSource({
            "PIONEERSchool"
    })

    public void  schoolTestBYname(String name){
        assertNotNull( schoolService.findbyschoolname(name));
    }
}
