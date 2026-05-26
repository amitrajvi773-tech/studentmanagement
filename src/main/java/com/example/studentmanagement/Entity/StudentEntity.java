package com.example.studentmanagement.Entity;

import jdk.jfr.DataAmount;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Data
@Entity
public class StudentEntity {
    private String studentname;
}
