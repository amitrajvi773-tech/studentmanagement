package com.example.studentmanagement.Service;

import com.example.studentmanagement.DTO.EmailValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailValidationService {

    @Value("${email_api_key}")
    private String API_KEY;




    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    public void test() {
        System.out.println("API KEY = " + API_KEY);
    }
    public boolean EmailValidation(String email) {
        String url = "http://apilayer.net/api/check?access_key=" + API_KEY + "&email=" + email;

        EmailValidationResponse response = restTemplate.getForObject(url, EmailValidationResponse.class);
        return response != null && response.isFormatValid()
                && response.isMxFound()
                && response.isSmtpCheck();
//        return true;


    }

}
