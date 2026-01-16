package com.cheloakachelo.email_service.controller;

import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.cheloakachelo.email_service.adapters.EmailSenderGateway;
import com.cheloakachelo.email_service.application.EmailSenderService;
import com.cheloakachelo.email_service.core.EmailRequest;
import com.cheloakachelo.email_service.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendemail")
public class EmailServiceController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailServiceController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }


    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email sent succesfully");
        } catch (EmailServiceException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error while sending email " + e.getMessage());
        }
    }
}
