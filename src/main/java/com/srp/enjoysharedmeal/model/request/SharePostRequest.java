package com.srp.enjoysharedmeal.model.request;

import com.srp.enjoysharedmeal.model.entity.Food;
import com.srp.enjoysharedmeal.model.entity.Location;
import com.srp.enjoysharedmeal.model.validation.FoodSizeConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Value
public class SharePostRequest {

    @NotBlank
    String title;

    @NotBlank
    String details;

    @FoodSizeConstraint
    Set<Food> foods;

    // TODO : For now the photo is optional but we need to make this required 2
    List<String> photos;

    @NotNull
    Location location;

}