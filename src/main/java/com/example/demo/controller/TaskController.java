package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;




@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public Iterable<Task> getTasks() {
        return taskService.findAll();
    }
    
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.findById(id);
    }
    
    @GetMapping("/{taskId}/users")
    public Set<User> getUsersByTaskId(@PathVariable int taskId) {

        Set<User> users = taskService.getUsersByTaskId(taskId); 
        
        return users;
    }
    

    @GetMapping("/{taskId}/add-user/{userId}")
    public String addUserToTask(@PathVariable int taskId, @PathVariable int userId) {
        if (taskService.addUserToTask(taskId, userId)) {
            return "User added to task";
        } else {
            return "User or task not found";
        }
    }

}
