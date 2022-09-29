package com.srp.enjoysharedmeal.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
