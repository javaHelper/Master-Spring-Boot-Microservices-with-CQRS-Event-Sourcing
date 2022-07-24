package com.example.demo.controllers;

import com.example.demo.commands.RegisterUserCommand;
import com.example.demo.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/registerUser")
public class RegisterUserController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisterUserCommand command){
    	String id = UUID.randomUUID().toString();
        command.setId(id);
        try {
           commandGateway.send(command);
           return new ResponseEntity<>(new RegisterUserResponse(id, "User successfully registered!"), HttpStatus.CREATED);
        }catch (Exception e){
            String msg = "Error while processing register user request for id - "+ id;
            System.out.println(e.toString());
            return new ResponseEntity<>(new RegisterUserResponse(id, msg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
