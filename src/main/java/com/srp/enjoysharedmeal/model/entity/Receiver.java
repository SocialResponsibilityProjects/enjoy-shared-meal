package com.srp.enjoysharedmeal.model.entity;

import com.srp.enjoysharedmeal.model.base.BaseUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reciever")
public class Receiver extends BaseUser {

    @OneToMany
    private List<Food> receivedFoods;

    @OneToMany
    private List<Feedback> feedbacks;
}
