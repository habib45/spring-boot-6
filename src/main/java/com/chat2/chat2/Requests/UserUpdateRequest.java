package com.chat2.chat2.Requests;


public class UserUpdateRequest {

    private String name;
    private String password;  // Include only updatable fields
    private String email;
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

