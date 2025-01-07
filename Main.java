package com.example.registrationmodule;

import com.example.registrationmodule.model.User;
import com.example.registrationmodule.service.UserService;

public class Main {
    public static void main(String[] args) {
        // Create a User object
        User user = new User("john.doe@example.com", "john_doe", "password123");

        // Create a UserService object
        UserService userService = new UserService();

        // Call the method to display email
        userService.displayUserEmail(user);
    }
}
