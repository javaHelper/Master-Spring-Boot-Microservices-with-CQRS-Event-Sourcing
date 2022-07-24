package com.example.demo.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserLookupResponse;
import com.example.demo.models.User;
import com.example.demo.queries.FindAllUsersQuery;
import com.example.demo.queries.FindUserByIdQuery;
import com.example.demo.queries.SearchUsersQuery;
import com.example.demo.repositories.UserRepository;


@Service
public class UserQueryHandlerImpl implements UserQueryHandler {
	@Autowired
	private UserRepository userRepository;

	@QueryHandler
	@Override
	public UserLookupResponse getUserById(FindUserByIdQuery findUserByIdQuery) {
		Optional<User> optionalUser = userRepository.findById(findUserByIdQuery.getId());
		return optionalUser.isPresent() ? new UserLookupResponse(optionalUser.get()) : null;
	}

	@QueryHandler
	@Override
	public UserLookupResponse searchUsers(SearchUsersQuery searchUsersQuery) {
		List<User> users = new ArrayList<>(userRepository.findByFilterRegex(searchUsersQuery.getFilter()));
		return new UserLookupResponse(users);
	}

	@QueryHandler
	@Override
	public UserLookupResponse getAllUsers(FindAllUsersQuery findAllUsersQuery) {
		List<User> users = new ArrayList<>(userRepository.findAll());
		return new UserLookupResponse(users);
	}
}
