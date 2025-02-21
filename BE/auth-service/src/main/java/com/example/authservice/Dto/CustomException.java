package com.example.authservice.Dto;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}