package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.Todo;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
}
