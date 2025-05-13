package com.todoapp.todo.persistence.inmemory;

import com.todoapp.todo.Todo;
import com.todoapp.todo.application.ITodoRepository;

import java.util.ArrayList;
import java.util.List;

public class TodoInMemoryRepository implements ITodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    public void add(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getAll() {
        return todos;
    }

    public boolean exists(String name) {
        return todos.stream().anyMatch(t -> t.getName().equalsIgnoreCase(name));
    }
}
