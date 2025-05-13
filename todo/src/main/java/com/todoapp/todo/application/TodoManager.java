package com.todoapp.todo.application;

import com.todoapp.todo.Todo;
import java.util.List;

public class TodoManager {

    private final ITodoRepository repository;

    public TodoManager(ITodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(Todo todo) {
        if (repository.exists(todo.getName())) {
            throw new IllegalArgumentException("Ce todo existe déjà");
        }
        repository.add(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.getAll();
    }
}
