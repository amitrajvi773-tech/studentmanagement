package com.example.studentmanagement.DTO;

import com.example.studentmanagement.Entity.StudentEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Data
public class SchoolGetDTO {

    private String schoolname;

    List<StudentEntity> studentEntries=new ArrayList<>();


}
