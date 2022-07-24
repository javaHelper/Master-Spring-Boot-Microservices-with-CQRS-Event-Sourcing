package com.example.demo.commands;

import com.example.demo.models.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private String id;
    
    @NotNull(message = "No user details were supplied")
    @Valid
    private User user;
}
