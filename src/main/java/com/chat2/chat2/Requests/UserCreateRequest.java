package com.chat2.chat2.Requests;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateRequest {

   
  @NotEmpty(message = "The name is required.")
  @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.") 
      
    private String name;
    private String email;
    private String username;
    private String password;
    private String mobile;
    private String status;
    private Date createdDate;
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
    public String getUsername() {
      return username;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }
    public Date getCreatedDate() {
      return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
    }
   
    
}

