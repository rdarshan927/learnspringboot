package com.rd927.second.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rd927.second.services.*;
import com.rd927.second.models.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/sheporausers")
public class AuthController {

    @Autowired
    private UserService userService;

    // Endpoint for user registration
    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
        
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        // Extract email and password from the loginRequest object
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        // return userService.loginUser(email, password);
        System.out.println("Came 1");
        return userService.loginUser(email, password);
    }
    
}
