package com.chat2.chat2.Controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class HomeController {

    @GetMapping("/home")    
    public String getHome(HttpServletRequest request){
        return "Home Page " + request.getSession().getId();

    }

    // @GetMapping("/csrf-token")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

}
