package com.srp.enjoysharedmeal.controller;

import com.srp.enjoysharedmeal.model.dto.UserDTO;
import com.srp.enjoysharedmeal.model.dto.UserLoginDTO;
import com.srp.enjoysharedmeal.model.dto.UserRegisterDTO;
import com.srp.enjoysharedmeal.model.entity.User;
import com.srp.enjoysharedmeal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.signIn(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserRegisterDTO userDataDTO) {
        User user = new User();
        user.setUsername(userDataDTO.getUsername());
        user.setPassword(userDataDTO.getPassword());
        return userService.signup(user, false);
    }

    @DeleteMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/me")
    public UserDTO whoami(HttpServletRequest req) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userService.whoami(req), UserDTO.class);
    }

}