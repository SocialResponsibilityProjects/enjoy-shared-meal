package com.srp.enjoysharedmeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AuthUser {

    @Pattern(regexp = "(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})")
    @Column(unique = true)
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    private Location location;

}