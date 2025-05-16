package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    Long id;

    @NotNull(message = "Name is required")
    String name;

    @Email(message = "Email must be in valid format")
    @NotNull(message = "Email is required")
    String email;

    @Range(min = 18L, max = 60L, message = "Age should be in range: [18,60]")
    int age;

    @PastOrPresent(message = "Date cannot be future date")
    LocalDate dateOfJoining;

    @JsonProperty("isActive")
    boolean isActive;
    double salary;

    DepartmentDTO department;
}
