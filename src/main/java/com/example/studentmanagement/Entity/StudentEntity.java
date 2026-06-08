package com.example.studentmanagement.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "write your name")
    private String studentname;

    @Email
    private String email;

    @NotBlank(message = "write your branch")
    private String branch;



}
