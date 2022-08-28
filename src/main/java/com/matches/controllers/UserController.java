package com.matches.controllers;

import com.matches.entities.User;
import com.matches.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/api/user/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @PostMapping("/api/user")
    public User saveUser(@RequestBody User user) throws Exception{
        return userService.saveUser(user);
    }
}
