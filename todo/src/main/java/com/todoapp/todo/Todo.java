package com.todoapp.todo;

public class Todo {
	private String name;
	private String dueDate;

	public Todo() {}

	public Todo(String name, String dueDate) {
		this.name = name;
		this.dueDate = dueDate;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDueDate() { return dueDate; }
	public void setDueDate(String dueDate) { this.dueDate = dueDate; }
}
