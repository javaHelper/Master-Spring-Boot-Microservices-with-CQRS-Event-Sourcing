package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Size(min = 2, message = "username must have minimum of 2 characters")
    private String username;

    @Size(min = 7, message = "username must have minimum of 7 characters")
    private String password;

    @NotNull(message = "specify at least 1 user role")
    private List<Role> roles;
}
