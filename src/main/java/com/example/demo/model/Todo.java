package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Todo {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;

    private String description;
    private Date date;

    @OneToMany(mappedBy = "todo")
    List<Task> tasks;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
