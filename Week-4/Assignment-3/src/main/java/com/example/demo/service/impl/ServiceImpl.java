package com.example.demo.service.impl;

import com.example.demo.dao.Dao;
import com.example.demo.model.User;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

    @Autowired
    private Dao userDao;

    @Override
    public User getUser (String email, String password) {
        return userDao.getUser(email, password);
    }

    @Override
    public User createUser(String email, String password) {
        return userDao.createUser(email, password);
    }

    @Override
    public User checkUser(String email) {
        return userDao.checkUser(email);
    }
}