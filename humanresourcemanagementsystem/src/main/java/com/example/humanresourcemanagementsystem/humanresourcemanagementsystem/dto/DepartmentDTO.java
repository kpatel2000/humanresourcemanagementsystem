package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto;

import com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.validation.PrimeNumber;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentDTO {

    Long id;
    String title;

    @PrimeNumber
    @NotNull
    int age;
}
