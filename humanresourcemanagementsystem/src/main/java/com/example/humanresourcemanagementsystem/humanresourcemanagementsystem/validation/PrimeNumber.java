package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {PrimeNumberValidationImpl.class}
)
public @interface PrimeNumber {

    String message() default "Not a valid prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
