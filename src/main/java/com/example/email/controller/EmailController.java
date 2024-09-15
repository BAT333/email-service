package com.example.email.controller;

import com.example.email.model.DataEmailDTO;
import com.example.email.model.EmailValidDTO;
import com.example.email.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/propertie")
@SecurityRequirement(name = "bearer-key")
@CrossOrigin(origins = "http://172.27.64.1:8082")
public class EmailController {
    @Autowired
    private EmailService service;
    @PostMapping("/send")
    @Transactional
    @Operation(summary ="Email sent", description ="Send an email without saving in the database")
    public ResponseEntity<DataEmailDTO> SendEmail(@RequestBody @Valid DataEmailDTO dto, @PathVariable("id") Long id){
        return ResponseEntity.ok(service.sendEmail(dto));
    }
    @PostMapping("/send/save")
    @Transactional
    @Operation(summary ="Email sent", description ="Send an email by saving it in the database")
    public ResponseEntity<DataEmailDTO> SendEmailSave(@RequestBody @Valid DataEmailDTO dto, @PathVariable("id") Long id){
        return ResponseEntity.ok(service.sendEmailSave(dto));
    }
    @PostMapping("/send/valid/{id}")
    @Transactional
    @Operation(summary ="Send validation email", description ="Get the user's email and send a validation email to the customer")
    public ResponseEntity<DataEmailDTO> SendEmailValid(@RequestBody @Valid EmailValidDTO dto, @PathVariable("id") Long id){
        return ResponseEntity.ok(service.sendEmailValid(dto));
    }
    @GetMapping("/valid/{id}")
    @Operation(summary ="Validate the email", description ="Validate the user's email and activate the user")
    public ResponseEntity SendEmailValid( @PathVariable("id") String id){
        service.validEmail(id);
        return ResponseEntity.ok().build();

    }

}
