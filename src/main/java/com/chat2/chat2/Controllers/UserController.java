package com.chat2.chat2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.chat2.chat2.Models.User;
import com.chat2.chat2.Requests.UserCreateRequest;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.Services.UserService;

import jakarta.validation.Valid;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User createRequest,BindingResult result) {
        return ResponseEntity.ok(this.userService.CreateUser(createRequest));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody UserUpdateRequest updateRequest) {
        return ResponseEntity.ok(this.userService.updateUser(id, updateRequest));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
