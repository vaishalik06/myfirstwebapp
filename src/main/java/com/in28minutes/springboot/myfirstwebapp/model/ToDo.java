package com.in28minutes.springboot.myfirstwebapp.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ToDo {
    private int id;
    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean complete;

    public ToDo(int id, String username, String description, LocalDate targetDate, boolean complete) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String
    toString() {
        return "ToDo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", complete=" + complete +
                '}';
    }
}
