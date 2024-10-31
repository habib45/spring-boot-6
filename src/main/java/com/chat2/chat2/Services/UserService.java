package com.chat2.chat2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chat2.chat2.Models.User;
import com.chat2.chat2.Repositories.UserRepository;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.exception.DataNotFoundException;

import jakarta.transaction.Transactional;

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

    @Transactional
    public User updateUser(Long userId, UserUpdateRequest updateRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Only update password if it is not null or empty
        if (updateRequest.getPassword() != null && !updateRequest.getPassword().isEmpty()) {
            String hashedPassword = encoder.encode(updateRequest.getPassword());
            user.setPassword(hashedPassword);
        }

        // Update other fields
        if (updateRequest.getEmail() != null) {
            user.setEmail(updateRequest.getEmail());
        }
        if (updateRequest.getMobile() != null) {
            user.setMobile(updateRequest.getMobile());
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