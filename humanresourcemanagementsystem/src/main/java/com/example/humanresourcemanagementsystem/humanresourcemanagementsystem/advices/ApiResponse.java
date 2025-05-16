package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    LocalDateTime timeStamp;
    T data;
    ApiError apiError;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }
}
