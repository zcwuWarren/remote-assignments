package com.example.demo.service;

import com.example.demo.model.User;


public interface Service {
    User getUser(String email, String password);

    User createUser(String email, String password);

    User checkUser(String email);
}

