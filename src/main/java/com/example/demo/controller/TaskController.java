package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.TaskService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("path")
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @GetMapping("/tasks/{taskId}")
    public Set<User> getUsersByTaskId(@PathVariable int taskId) {

        Set<User> users = taskService.getUsersByTaskId(taskId); 
        
        return users;
    }
    

}
