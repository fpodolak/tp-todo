package com.todoapp.todo.application;

import com.todoapp.todo.Todo;

import java.util.List;

public interface ITodoRepository {
    void add(Todo todo);
    List<Todo> getAll();
    boolean exists(String name);
}
