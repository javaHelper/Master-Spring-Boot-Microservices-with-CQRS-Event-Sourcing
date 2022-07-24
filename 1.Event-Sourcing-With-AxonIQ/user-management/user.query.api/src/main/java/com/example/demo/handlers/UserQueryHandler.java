package com.example.demo.handlers;

import com.example.demo.dto.UserLookupResponse;
import com.example.demo.queries.FindAllUsersQuery;
import com.example.demo.queries.FindUserByIdQuery;
import com.example.demo.queries.SearchUsersQuery;

public interface UserQueryHandler {
	UserLookupResponse getUserById(FindUserByIdQuery findUserByIdQuery);
	UserLookupResponse searchUsers(SearchUsersQuery searchUsersQuery);
	UserLookupResponse getAllUsers(FindAllUsersQuery findAllUsersQuery);
}
