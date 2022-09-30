package com.srp.enjoysharedmeal.model.entity;

import com.srp.enjoysharedmeal.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location extends BaseEntity {

    private Double latitude;
    private Double longitude;

}
