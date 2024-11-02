package com.chat2.chat2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.chat2.chat2.Models.User;
import com.chat2.chat2.Requests.UserCreateRequest;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.Services.UserService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController {

    @Autowired
    private UserService userService;    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.ofNullable(users);
        }else{
            return ResponseEntity.ok(users);
        }
        
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

    @RequestMapping(value = "/pagindAndShortingUser/{pageNumber}/{pageSize}", method=RequestMethod.GET)
    public Page<User> userPegination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return this.userService.getUserPaginator(pageNumber,pageSize,sort);
    }
    
}
