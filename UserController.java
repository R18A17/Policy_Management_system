package com.example.registrationmodule.controller;

import com.example.registrationmodule.model.User;
import com.example.registrationmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred during registration", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            userService.updateProfile(id, userDetails);
            return new ResponseEntity<>("Profile updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        try {
            userService.deleteProfile(id);
            return new ResponseEntity<>("Profile deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Login user (basic implementation, needs improvement)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        boolean isAuthenticated = userService.authenticateUser(loginUser.getUsername(), loginUser.getPassword());

        if (isAuthenticated) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    // Logout user (mock implementation)
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
    }
}
