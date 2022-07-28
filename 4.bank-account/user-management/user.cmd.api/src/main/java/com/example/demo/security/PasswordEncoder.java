package com.example.demo.security;

public interface PasswordEncoder {
    String hashPassword(String password);
}
