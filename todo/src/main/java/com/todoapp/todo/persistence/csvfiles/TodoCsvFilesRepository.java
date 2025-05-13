package com.todoapp.todo.persistence.csvfiles;

import com.todoapp.todo.Todo;
import com.todoapp.todo.application.ITodoRepository;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class TodoCsvFilesRepository implements ITodoRepository {

    private final Path filePath;

    public TodoCsvFilesRepository() {
        String appData = System.getenv("APPDATA");
        if (appData == null) appData = System.getProperty("user.home");
        this.filePath = Paths.get(appData, "todos.csv");

        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Impossible de créer le fichier CSV", e);
        }
    }

    @Override
    public void add(Todo todo) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(todo.getName() + "," + (todo.getDueDate() != null ? todo.getDueDate() : "") + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Erreur d’écriture CSV", e);
        }
    }

    @Override
    public List<Todo> getAll() {
        try {
            return Files.readAllLines(filePath).stream()
                    .filter(line -> !line.isBlank())
                    .map(line -> {
                        String[] parts = line.split(",", 2);
                        return new Todo(parts[0], parts.length > 1 ? parts[1] : null);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Erreur de lecture CSV", e);
        }
    }

    @Override
    public boolean exists(String name) {
        return getAll().stream().anyMatch(t -> t.getName().equalsIgnoreCase(name));
    }
}
