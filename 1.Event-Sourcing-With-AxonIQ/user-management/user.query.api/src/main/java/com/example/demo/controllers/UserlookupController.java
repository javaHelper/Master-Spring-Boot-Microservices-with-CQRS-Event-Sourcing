package com.example.demo.controllers;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserLookupResponse;
import com.example.demo.queries.FindAllUsersQuery;
import com.example.demo.queries.FindUserByIdQuery;
import com.example.demo.queries.SearchUsersQuery;

@RestController
@RequestMapping("/api/v1/userLookup")
public class UserlookupController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/")
	public ResponseEntity<UserLookupResponse> getAllUsers(){
		try {
			FindAllUsersQuery query = new FindAllUsersQuery();
			UserLookupResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();
			
			if(response == null || response.getUsers() == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Failed to complete get all users request!";
			System.out.println(e.getMessage());
			return new ResponseEntity<>(new UserLookupResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<UserLookupResponse> getUserById(@PathVariable("id") String id){
		try {
			FindUserByIdQuery query = new FindUserByIdQuery(id);
			UserLookupResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();
			
			if(response == null || response.getUsers() == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Failed to complete get User By Id request!";
			System.out.println(e.getMessage());
			return new ResponseEntity<>(new UserLookupResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/byFilter/{filter}")
	public ResponseEntity<UserLookupResponse> searchUserByFilter(@PathVariable("filter") String filter){
		try {
			SearchUsersQuery query = new SearchUsersQuery(filter);
			UserLookupResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();
			
			if(response == null || response.getUsers() == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "Failed to complete get User By Filter request!";
			System.out.println(e.getMessage());
			return new ResponseEntity<>(new UserLookupResponse(msg), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
