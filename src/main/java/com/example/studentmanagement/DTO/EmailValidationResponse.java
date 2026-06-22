package com.example.studentmanagement.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmailValidationResponse {
    @JsonProperty("format_valid")
    private boolean formatValid;

    @JsonProperty("mx_found")
    private boolean mxFound;

    @JsonProperty("smtp_check")
    private boolean smtpCheck;}
