package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotEmpty(message = "firstname is mandatory")
    private String firstname;

    @NotEmpty(message = "lastname is mandatory")
    private String lastname;

    @NotEmpty(message = "Please provide valid email address")
    private String emailAddress;

    @NotNull(message = "Please provide Account Credentials")
    @Valid
    private Account account;
}
