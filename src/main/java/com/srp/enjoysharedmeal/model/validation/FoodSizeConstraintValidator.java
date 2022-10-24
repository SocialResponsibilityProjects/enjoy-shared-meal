package com.srp.enjoysharedmeal.model.validation;

import com.srp.enjoysharedmeal.model.entity.Food;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class FoodSizeConstraintValidator implements ConstraintValidator<FoodSizeConstraint, List<Food>> {

    @Override
    public boolean isValid(List<Food> foods, ConstraintValidatorContext constraintValidatorContext) {
        return foods.size() > 0 && foods.size() < 5;
    }
}
