package com.example.studentmanagement.ServiceTest;


import com.example.studentmanagement.Service.SchoolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SchoolServiceTest {
    @Autowired
    SchoolService schoolService;

    @Test
    void  schoolTest(){
        assertNotNull(schoolService.getAllSchool());

    }

    @ParameterizedTest
    @CsvSource({
            "PIONEERSchool"
    })
    void  schoolTestByname(String name){
        assertNotNull( schoolService.findbyschoolname(name));
    }
}
