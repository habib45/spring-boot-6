package com.chat2.chat2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chat2.chat2.Models.User;
import com.chat2.chat2.Repositories.UserRepository;
import com.chat2.chat2.Requests.UserCreateRequest;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.exception.DataNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User CreateUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if(user.getStatus().isEmpty()){
            user.setStatus("Active");
        }
        return this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long userId, UserUpdateRequest updateRequest) {
        User user = this.userRepository.findById(userId)
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

        if (updateRequest.getMobile() != null) {
            user.setMobile(updateRequest.getMobile());
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("User with ID " + id + " not found"));
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    public Page<User> getUserPaginator(Integer pageNumber, Integer pageSize, Sort sort) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,sort);      
        return this.userRepository.findAll(pageable);
    }
}