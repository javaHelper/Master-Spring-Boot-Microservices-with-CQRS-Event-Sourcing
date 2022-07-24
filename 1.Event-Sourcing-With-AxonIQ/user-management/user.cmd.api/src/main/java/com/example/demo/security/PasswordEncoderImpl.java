package com.example.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderImpl implements PasswordEncoder{
    @Override
    public String hashPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String hashedPassword = bCryptPasswordEncoder.encode(password);
        return hashedPassword;
    }
}
