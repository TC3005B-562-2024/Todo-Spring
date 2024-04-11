package com.example.demo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task todo){
        return taskRepository.save(todo);
    }

    public Task findById(int id){
        Optional<Task> taskOptional=taskRepository.findById(id);
        if(taskOptional.isPresent()){
            return taskOptional.get();
        }
        return null;
    }

    public Set<User> getUsersByTaskId(int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (!task.isPresent()) {
            return null;
        }

        Set<User> users = task.get().getRelatedUsers();        
        
        return users;
    }
}
