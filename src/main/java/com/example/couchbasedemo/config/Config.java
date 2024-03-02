package com.example.couchbasedemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Admin";
    }

    @Override
    public String getPassword() {
        return "Admin123";
    }

    @Override
    public String getBucketName() {
        return "Bucket1";
    }
}
