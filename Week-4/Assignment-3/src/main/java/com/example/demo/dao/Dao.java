package com.example.demo.dao;

import com.example.demo.model.User;

public interface Dao {
    User getUser (String email, String password);

    User createUser(String email, String password);

    User checkUser(String email);
}
