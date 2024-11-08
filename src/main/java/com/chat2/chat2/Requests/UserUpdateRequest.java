package com.chat2.chat2.Requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserUpdateRequest {

    private String name;
    private String password;  // Include only updatable fields
    @NotEmpty(message = "The email is required.")
    private String email;
    @Size(min = 10, max = 14, message = "The length of mobile must be between 10 and 14 characters.") 
    private String mobile;

   // Getters and Setters
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public String getMobile() {
      return mobile;
    }
    public void setMobile(String mobile) {
      this.mobile = mobile;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }

   
    
}

