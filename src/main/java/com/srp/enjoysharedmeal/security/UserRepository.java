package com.srp.enjoysharedmeal.security;

import com.srp.enjoysharedmeal.model.entity.AuthUser;
import com.srp.enjoysharedmeal.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    Optional<AuthUser> findByUsername(String username);

    void deleteByUsername(String username);

}
