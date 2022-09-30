package com.srp.enjoysharedmeal.model.entity;

import com.srp.enjoysharedmeal.model.base.BaseUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sharer")
public class Sharer extends BaseUser {

    @OneToOne
    private Location location;

    @OneToMany
    private List<Food> sharedFoods;

    @OneToMany
    private List<Feedback> feedbacks;

}
