package com.example.learningp.learningp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningp.learningp.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail(String email);

}
