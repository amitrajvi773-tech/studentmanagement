package com.example.studentmanagement.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmailValidationResponse {
    @JsonProperty("is_smpt_valid")
    private SmtpValid smtpValid;

    @Data
    public static class SmtpValid {
        private boolean value;
    }}
