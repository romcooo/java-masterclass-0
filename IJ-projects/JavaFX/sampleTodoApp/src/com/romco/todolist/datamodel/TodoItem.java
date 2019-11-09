package com.romco.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem {
    private String description, details;
    private LocalDate dueDate;

    public TodoItem(String description, String details, LocalDate dueDate) {
        this.description = description;
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
