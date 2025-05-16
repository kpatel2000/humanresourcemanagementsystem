package com.example.humanresourcemanagementsystem.humanresourcemanagementsystem.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidationImpl implements ConstraintValidator<PrimeNumber, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if(integer <= 1) return false;

        for (int start = 2; start <= Math.sqrt(integer); start++) {
            if(integer % start == 0) return false;
        }
        return true;
    }
}
