package com.example.demo.handlers;

import com.example.demo.events.UserRegisteredEvent;
import com.example.demo.events.UserRemovedEvent;
import com.example.demo.events.UserUpdatedEvent;
import com.example.demo.repositories.UserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;


@Service
@ProcessingGroup("user-group")
public class UserEventHandlerImpl implements  UserEventHandler{

    private final UserRepository userRepository;

    public UserEventHandlerImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @EventHandler
    @Override
    public void on(UserRegisteredEvent event) {
        userRepository.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(UserUpdatedEvent event) {
        userRepository.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(UserRemovedEvent event) {
        userRepository.deleteById(event.getId());
    }
}
