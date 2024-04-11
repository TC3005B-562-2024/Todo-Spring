package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;



@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }
    
    
}
