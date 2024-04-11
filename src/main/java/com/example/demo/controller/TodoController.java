package com.example.demo.controller;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.save(todo));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodos(){
        List<TodoListDTO> response=new ArrayList<>();
        List<Todo> dbTodos=todoService.findAll();

        for(Todo todo : dbTodos) {
            TodoListDTO dto = new TodoListDTO(todo);
            dto.setIs_complete(todoService.checkCopletion(dto.getId()));

            response.add(dto);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable int id){
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.save(todo));
    }

    @PostMapping("/add-task/{id}")
    public ResponseEntity<?> addTask(@PathVariable int id, @RequestBody Task task){
        todoService.addTask(id,task);
        return ResponseEntity.ok("Task added successfully");
    }

    @PostMapping("/complete-task/{id}")
    public ResponseEntity<?> completeTask(@PathVariable int id){
        Task task =  taskService.findById(id);
        task.setIs_complete(true);
        taskService.save(task);
        return ResponseEntity.ok("Task marked as completed!");
    }


}
