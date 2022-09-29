package com.srp.enjoysharedmeal.security;

import com.srp.enjoysharedmeal.model.entity.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> byUsername = userRepository.findByUsername(username);
        AuthUser authUser = byUsername
                .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(authUser.getPassword())
                .authorities(authUser.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }

}