package com.example.demo.dto;

import com.example.demo.model.Todo;

public class TodoListDTO {

    public TodoListDTO(Todo todo) {
        this.id = todo.getId();
        this.description = todo.getDescription();
    }
    private int id;
    private String description;
    private boolean is_complete;

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
