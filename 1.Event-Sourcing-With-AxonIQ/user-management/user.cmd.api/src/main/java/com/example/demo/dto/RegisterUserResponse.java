package com.example.demo.dto;


public class RegisterUserResponse extends BaseResponse {
    private String id;

    public RegisterUserResponse(String id,String message) {
        super(message);
        this.id = id;
    }
}
