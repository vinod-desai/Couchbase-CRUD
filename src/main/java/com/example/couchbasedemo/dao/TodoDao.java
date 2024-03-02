package com.example.couchbasedemo.dao;

import com.example.couchbasedemo.model.Todo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoDao extends CouchbaseRepository<Todo, String> {
    List<Todo> findTodosByName(String name);
}
