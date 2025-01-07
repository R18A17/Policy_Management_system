package com.example.registrationmodule.service;

import com.example.registrationmodule.model.User;
@service
public class UserService {

    public void displayUserEmail(User user) {
        if (user != null) {
            String email = user.getEmail();  // This calls the getEmail() method on the User class
            System.out.println("User's Email: " + email);
        } else {
            System.out.println("User object is null");
        }
    }

    // Method to register a user (mocked implementation)
    public void registerUser(User user) {
        if (user != null && user.getEmail() != null && user.getUsername() != null) {
            // In a real application, you would save the user to the database here
            System.out.println("User registered: " + user.getUsername());
        } else {
            System.out.println("User registration failed. Missing data.");
        }
    }

    // Method to update the user's profile (mocked implementation)
    public void updateProfile(Long id, User userDetails) {
        if (id != null && userDetails != null) {
            // In a real application, you would update the user data in the database
            System.out.println("Profile updated for user with ID: " + id);
        } else {
            System.out.println("User or ID is invalid.");
        }
    }

    // Method to delete a user's profile (mocked implementation)
    public void deleteProfile(Long id) {
        if (id != null) {
            // In a real application, you would delete the user from the database
            System.out.println("Profile deleted for user with ID: " + id);
        } else {
            System.out.println("Invalid user ID.");
        }
    }

    // Method to authenticate a user (mocked implementation)
    public boolean authenticateUser(String username, String password) {
        // For now, we mock the authentication process
        if ("testuser".equals(username) && "password123".equals(password)) {
            return true;  // Successful authentication
        } else {
            return false;  // Failed authentication
        }
    }
}
