package com.example.email.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailValidDTO(
        @Email
        @NotBlank
        String emailTo
) {
}
