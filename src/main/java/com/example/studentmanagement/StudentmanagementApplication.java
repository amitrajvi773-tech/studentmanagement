package com.example.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentmanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentmanagementApplication.class, args);

	}

	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
