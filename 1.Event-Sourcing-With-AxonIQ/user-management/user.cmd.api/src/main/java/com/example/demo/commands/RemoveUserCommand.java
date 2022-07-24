package com.example.demo.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
public class RemoveUserCommand {
    @TargetAggregateIdentifier
    private String id;
}
