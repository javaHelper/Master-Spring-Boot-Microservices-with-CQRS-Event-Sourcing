package com.example.demo.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commands.RemoveUserCommand;
import com.example.demo.dto.BaseResponse;

@RestController
@RequestMapping("/api/v1/removeUser")
public class RemoveUserController {
	@Autowired
	private CommandGateway commandGateway;

	@DeleteMapping("/{id}")
	public ResponseEntity<BaseResponse> removeUser(@PathVariable("id") String id) {
		try {
			commandGateway.send(new RemoveUserCommand(id));
			return new ResponseEntity<>(new BaseResponse("User successfully removed!"), HttpStatus.OK);
		}catch (Exception e){
			String msg = "Error while processing remove user request for id - "+ id;
			System.out.println(e.toString());
			return new ResponseEntity<>(new BaseResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
