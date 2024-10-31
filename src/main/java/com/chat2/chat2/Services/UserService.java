package com.chat2.chat2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chat2.chat2.Models.User;
import com.chat2.chat2.Repositories.UserRepository;
import com.chat2.chat2.exception.DataNotFoundException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if(user.getStatus()==null){
            user.setStatus("Active");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("User with ID " + id + " not found"));
    }

    public void deleteById(Long id) {
        
        userRepository.deleteById(id);
        
    }
}