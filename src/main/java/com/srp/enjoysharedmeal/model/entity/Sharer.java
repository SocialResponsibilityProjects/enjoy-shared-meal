package com.srp.enjoysharedmeal.model.entity;

import com.srp.enjoysharedmeal.model.base.BaseUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sharer")
public class Sharer extends BaseUser {
    @Pattern(regexp = "(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})")
    @Column(unique = true)
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @OneToOne
    private Location location;
    /*private List<Food> sharedFoods;
    private List<Feedback> feedbacks;*/

}
