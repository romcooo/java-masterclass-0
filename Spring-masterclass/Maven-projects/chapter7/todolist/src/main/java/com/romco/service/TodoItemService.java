package com.romco.service;

import com.romco.model.TodoData;
import com.romco.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem toAdd);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem toUpdate);
    TodoData getData();
}
