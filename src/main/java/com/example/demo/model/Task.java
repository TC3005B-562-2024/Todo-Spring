package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    private Todo todo;

    private boolean is_complete;

    @ManyToMany
    @JoinTable(
            name = "usertask",
            joinColumns = @JoinColumn(name = "taskid"),
            inverseJoinColumns = @JoinColumn(name = "userid")
    )
    Set<User> relatedUsers;

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Set<User> getRelatedUsers() {
        return relatedUsers;
    }

    public void setRelatedUsers(Set<User> relatedUsers) {
        this.relatedUsers = relatedUsers;
    }
    
}
