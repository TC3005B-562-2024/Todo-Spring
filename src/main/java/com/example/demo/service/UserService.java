package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository repository;

    public User save(User user){
        return repository.save(user);
    }

    public User findById(int id){
        Optional<User> taskOptional=repository.findById(id);
        if(taskOptional.isPresent()){
            return taskOptional.get();
        }
        return null;
    }
}
