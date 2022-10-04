package com.srp.enjoysharedmeal;

import com.srp.enjoysharedmeal.model.dto.UserRegisterDTO;
import com.srp.enjoysharedmeal.security.UserRepository;
import com.srp.enjoysharedmeal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestUsersInit implements ApplicationRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) {

        // Creating a sample Admin USER
        UserRegisterDTO testAdmin = UserRegisterDTO.builder()
                .username("test-admin")
                .password("admin123")
                .email("admin@mail.com")
                .phone("+905554443322")
                .build();
        if (!userRepository.existsByUsername(testAdmin.getUsername())) {
            userService.signup(testAdmin, true);
        }

        // Creating a sample USER
        UserRegisterDTO testUser = UserRegisterDTO.builder()
                .username("test-user")
                .password("user123")
                .email("user@mail.com")
                .phone("+905554443321")
                .build();
        if (!userRepository.existsByUsername(testUser.getUsername())) {
            userService.signup(testUser, false);
        }

    }

}