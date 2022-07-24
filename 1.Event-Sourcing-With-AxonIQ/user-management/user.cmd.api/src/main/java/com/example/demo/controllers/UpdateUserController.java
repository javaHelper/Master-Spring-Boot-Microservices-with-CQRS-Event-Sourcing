package com.example.demo.controllers;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commands.UpdateUserCommand;
import com.example.demo.dto.BaseResponse;

@RestController
@RequestMapping("/api/v1/updateUser")
public class UpdateUserController {

	@Autowired
	private CommandGateway commandGateway;

	@PutMapping("/{id}")
	public ResponseEntity<BaseResponse> updateUser(@Valid @RequestBody UpdateUserCommand command, 
												  @PathVariable("id") String id) {

		command.setId(id);
		try {
			commandGateway.send(command);
			return new ResponseEntity<>(new BaseResponse("User successfully updated!"), HttpStatus.OK);
		}catch (Exception e){
			String msg = "Error while processing update user request for id - "+ id;
			System.out.println(e.toString());
			return new ResponseEntity<>(new BaseResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}