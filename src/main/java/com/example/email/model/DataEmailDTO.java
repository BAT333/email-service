package com.example.email.model;


import com.example.email.domain.EmailEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataEmailDTO(
        @NotBlank
        String ownerRef,
        @Email
        @NotBlank
        String emailTo,
        @NotBlank
        String subject,
        @NotBlank
        String text
) {


    public DataEmailDTO(EmailEntity email) {
        this(email.getOwnerRef(), email.getEmailTo(), email.getSubject(), email.getText());
    }


}
