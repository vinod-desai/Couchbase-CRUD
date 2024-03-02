package com.example.couchbasedemo.service;

import com.example.couchbasedemo.dao.TodoDao;
import com.example.couchbasedemo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public List<Todo> getTodos() {
        return todoDao.findAll();
    }

    public Todo getTodo(String id) throws ResponseStatusException {
        Todo todo = todoDao.findById(id).orElse(null);
        isTodoValid(id, todo);
        return todo;
    }

    public Todo createTodo(@RequestBody Todo todo) {
        return todoDao.save(todo);
    }

    public Todo updateTodo(String id, Todo todo) throws ResponseStatusException {
        if (todo == null || !id.equals(todo.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
        return todoDao.save(todo);
    }

    public void deleteTodo(String id) {
        todoDao.deleteById(id);
    }

    public List<Todo> getTodoByName(String name) {
        return todoDao.findTodosByName(name);
    }

    private void isTodoValid(String id, Todo todo) throws ResponseStatusException {
        String errorMessage = "Todo with id: " + id + " not found.";
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }
}
