package com.example.finalproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<CheckSalary, Integer> {

    @Override
    public void initialize(CheckSalary constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer price, ConstraintValidatorContext context) {
        return (price >= 100000 && price <= 3000000);
    }
}
