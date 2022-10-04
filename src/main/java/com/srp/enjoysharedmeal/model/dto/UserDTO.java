package com.srp.enjoysharedmeal.model.dto;

import com.srp.enjoysharedmeal.model.type.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String email;
    List<Role> roles;

}
