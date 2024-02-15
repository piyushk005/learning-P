package com.example.learningp.learningp.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningp.learningp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByRoleType(String roletype);

}
