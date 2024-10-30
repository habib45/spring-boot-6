package com.chat2.chat2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat2.chat2.Models.User;
import com.chat2.chat2.Repositories.UserRepository;
// import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        // String hashedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}