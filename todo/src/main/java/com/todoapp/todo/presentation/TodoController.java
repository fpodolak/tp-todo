package com.todoapp.todo.presentation;

import com.todoapp.todo.Todo;
import com.todoapp.todo.application.TodoManager;
import com.todoapp.todo.persistence.csvfiles.TodoCsvFilesRepository;
import com.todoapp.todo.Config;
import com.todoapp.todo.persistence.inmemory.TodoInMemoryRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoManager manager;

    public TodoController() {
        String type = Config.getRepositoryType();
        if ("CSV".equals(type)) {
            manager = new TodoManager(new TodoCsvFilesRepository());
        } else {
            manager = new TodoManager(new TodoInMemoryRepository());
        }
    }



    @PostMapping
    public ResponseEntity<?> create(@RequestBody Todo todo) {
        try {
            manager.addTodo(todo);
            return ResponseEntity.status(201).body("Todo created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Todo> getAll() {
        return manager.getAllTodos();
    }
}
