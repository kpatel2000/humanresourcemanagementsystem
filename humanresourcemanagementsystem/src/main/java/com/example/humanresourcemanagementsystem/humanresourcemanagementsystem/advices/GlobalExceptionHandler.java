package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.advices;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        ApiError apiError = ApiError.builder()
                .message(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        ApiError apiError = ApiError.builder()
                .message("Request Body is not correct")
                .subMessages(methodArgumentNotValidException
                        .getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(error-> error.getDefaultMessage())
                        .collect(Collectors.toList())
                )
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return buildResponseEntity(apiError);
    }
}
