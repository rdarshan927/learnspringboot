package com.rd927.second.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.rd927.second.repositories.UserRepository;
import com.rd927.second.models.User;
import com.rd927.second.utils.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Registers a new user if email and username are unique.
     * Validates the password criteria.
     */
    public ResponseEntity<?> registerUser(User user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "success", false,
                    "message", "Email already exists"));
        }

        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "success", false,
                    "message", "Username already exists"));
        }

        // Validate password strength
        if (user.getPassword().length() < 8 || !user.getPassword().matches(".*\\W.*")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "success", false,
                    "message", "Invalid password: Minimum length 8, at least one non-alphanumeric character required"));
        }

        // Save the user to the database without password encryption
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "message", "User registered successfully"));
    }

    /**
     * Authenticates a user by email and password.
     * Returns a JWT token upon successful login.
     */
    public ResponseEntity<?> loginUser(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "success", false,
                    "message", "User not found"));
        }

        // Check if the provided password matches the stored password
        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "success", false,
                    "message", "Invalid password"));
        }

        // Generate JWT token
        String jwtToken = jwtUtil.generateToken(user.getUsername());
        // In your controller method:
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Login successful");
        response.put("jwtToken", jwtToken);
        response.put("name", user.getUsername());

        return ResponseEntity.ok(response);
        // return ResponseEntity.ok(Map.of(
        //         "success", true,
        //         "message", "Login successful",
        //         "jwtToken", jwtToken,
        //         "name", user.getUsername()));
    }
}
