package com.example.finalproject.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.AssertTrue;

public class StringValidator implements ConstraintValidator<CheckString, String> {
    @Override
    public void initialize(CheckString constraintAnnotation) {
    }

    @Override
    @AssertTrue(message="ERROR! Individual customer should have gender and last name defined")
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return (!s.isEmpty() || (s != " "));
    }
}
