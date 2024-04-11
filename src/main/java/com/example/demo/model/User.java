package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)

    private int id;
    private String username;
    private String name;
    private String lastname;

    @ManyToMany(mappedBy = "relatedUsers")
    Set<Task> relatedTask;

    public User() {
    }    

    public User(int id, String username, String name, String lastname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
