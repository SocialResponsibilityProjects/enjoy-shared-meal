package com.srp.enjoysharedmeal.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = FoodSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FoodSizeConstraint {
    String message() default "The input list cannot contain more than 4 movies.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}