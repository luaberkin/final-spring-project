package com.example.finalproject.validator;

import javax.validation.Constraint;

@Constraint(validatedBy = StringValidator.class)
public @interface CheckString {
    String message() default "Value should not be empty";
}
