package com.chat2.chat2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat2.chat2.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
