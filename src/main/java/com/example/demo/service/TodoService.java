package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.Todo;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Todo save(Todo todo){
        todo.setDate(new Date());
        return todoRepository.save(todo);
    }

    public List<Todo> findAll(){
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo findById(int id){
        Optional<Todo> todoOptional=todoRepository.findById(id);
        if(todoOptional.isPresent()){
            return todoOptional.get();
        }
        return null;
    }

    public void addTask(int id, Task task){
        Todo todo=findById(id);
        if(todo!=null){
            task.setTodo(todo);
            taskRepository.save(task);
        }
    }

}
