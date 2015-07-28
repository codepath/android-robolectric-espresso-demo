package com.codepath.testingdemo.models;

public class User {
    private String userName;

    public User() {
        // do nothing
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
