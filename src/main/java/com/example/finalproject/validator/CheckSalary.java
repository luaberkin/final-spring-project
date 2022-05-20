package com.example.finalproject.validator;

import javax.validation.Constraint;

@Constraint(validatedBy = PriceValidator.class)
public @interface CheckSalary {
    String message() default "Price should be more than 1000, and less than 10000";
}
