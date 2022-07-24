package com.example.demo.aggregates;

import com.example.demo.commands.RegisterUserCommand;
import com.example.demo.commands.RemoveUserCommand;
import com.example.demo.commands.UpdateUserCommand;
import com.example.demo.events.UserRegisteredEvent;
import com.example.demo.events.UserRemovedEvent;
import com.example.demo.events.UserUpdatedEvent;
import com.example.demo.models.User;
import com.example.demo.security.PasswordEncoder;
import com.example.demo.security.PasswordEncoderImpl;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String id;
    private User user;

    private PasswordEncoder passwordEncoder;

    public UserAggregate(){
        passwordEncoder = new PasswordEncoderImpl();
    }

    @CommandHandler
    public UserAggregate(RegisterUserCommand command){
        User newUser = command.getUser();
        newUser.setId(command.getId());
        String password = newUser.getAccount().getPassword();

        var passwordEncoder = new PasswordEncoderImpl();
        String hashedPassword = passwordEncoder.hashPassword(password);

        newUser.getAccount().setPassword(hashedPassword);

        UserRegisteredEvent userRegisteredEvent = UserRegisteredEvent.builder()
                .id(command.getId())
                .user(newUser)
                .build();
        AggregateLifecycle.apply(userRegisteredEvent);
    }

    @CommandHandler
    public void handle(UpdateUserCommand command){
        User updatedUser = command.getUser();
        updatedUser.setId(command.getId());
        String password = updatedUser.getAccount().getPassword();

        String hashedPassword = passwordEncoder.hashPassword(password);
        updatedUser.getAccount().setPassword(hashedPassword);

        UserUpdatedEvent userUpdatedEvent = UserUpdatedEvent.builder()
                .id(command.getId())
                .user(updatedUser)
                .build();

        AggregateLifecycle.apply(userUpdatedEvent);
    }

    @CommandHandler
    public void handle(RemoveUserCommand command){
        UserRemovedEvent userRemovedEvent = new UserRemovedEvent();
        userRemovedEvent.setId(command.getId());

        AggregateLifecycle.apply(userRemovedEvent);
    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event){
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event){
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event){
        this.id = event.getId();
        this.user.setId(event.getId());
    }
}
