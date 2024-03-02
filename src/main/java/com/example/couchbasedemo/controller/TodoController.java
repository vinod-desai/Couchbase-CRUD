package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.model.Todo;
import com.example.couchbasedemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping("/todo")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @RequestMapping("/todo/{id}")
    public Todo getTodo(@PathVariable String id) throws ResponseStatusException {
        return todoService.getTodo(id);
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todo) throws ResponseStatusException {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }

    @RequestMapping("/todo-by-name/{name}")
    public List<Todo> getTodoByName(@PathVariable String name) throws ResponseStatusException {
        return todoService.getTodoByName(name);
    }
}
