package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
