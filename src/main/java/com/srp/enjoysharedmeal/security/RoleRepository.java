package com.srp.enjoysharedmeal.security;


import com.srp.enjoysharedmeal.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
