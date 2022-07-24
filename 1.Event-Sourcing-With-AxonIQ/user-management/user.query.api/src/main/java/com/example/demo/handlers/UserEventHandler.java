package com.example.demo.handlers;

import com.example.demo.events.UserRegisteredEvent;
import com.example.demo.events.UserRemovedEvent;
import com.example.demo.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}
