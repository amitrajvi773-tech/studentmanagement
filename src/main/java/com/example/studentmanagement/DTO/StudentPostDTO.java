package com.example.studentmanagement.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentPostDTO {


    @NotBlank(message = "write your name")
    private String studentname;

    @Email
    private String email;

    @NotBlank(message = "write your branch")
    private String branch;



}
