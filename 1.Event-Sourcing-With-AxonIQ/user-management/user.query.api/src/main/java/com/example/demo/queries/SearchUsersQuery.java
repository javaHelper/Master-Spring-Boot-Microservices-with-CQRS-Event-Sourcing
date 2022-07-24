package com.example.demo.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchUsersQuery {
	private String filter;
}
