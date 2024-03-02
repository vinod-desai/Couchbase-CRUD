package com.example.couchbasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
@EnableCouchbaseRepositories()
public class CouchbaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouchbaseDemoApplication.class, args);
    }

}
