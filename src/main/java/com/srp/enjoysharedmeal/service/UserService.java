package com.srp.enjoysharedmeal.service;

import com.srp.enjoysharedmeal.model.entity.AuthUser;
import com.srp.enjoysharedmeal.model.entity.Role;
import com.srp.enjoysharedmeal.model.entity.User;
import com.srp.enjoysharedmeal.security.JwtTokenProvider;
import com.srp.enjoysharedmeal.security.RoleRepository;
import com.srp.enjoysharedmeal.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    public AuthUser findByUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username not found!"));
    }

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username/password supplied");
        }
    }

    public String signUp(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Optional<Role> defaultRole = roleRepository.findById(2);
            Role clientRole = defaultRole.orElseThrow(() -> new RuntimeException("No such Role!"));
            user.setRoles(Collections.singletonList(clientRole));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new RuntimeException("Username is already in use");
        }
    }

    public void delete(String username) {
        AuthUser byUsername = findByUsername(username);
        if (isAdmin(byUsername)) {
            throw new RuntimeException("Related user can not be deleted!");
        }
        userRepository.deleteByUsername(username);
    }

    private boolean isAdmin(AuthUser user) {
        return user.getRoles().stream().anyMatch(role -> role.getRole_name().equals("ADMIN"));
    }

    public AuthUser search(String username) {
        AuthUser user;
        if (!userRepository.existsByUsername(username)) {
            user = findByUsername(username);
        } else {
            throw new RuntimeException("Username already exists!");
        }
        return user;
    }

    public AuthUser whoami(HttpServletRequest req) {
        return findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, findByUsername(username).getRoles());
    }

}