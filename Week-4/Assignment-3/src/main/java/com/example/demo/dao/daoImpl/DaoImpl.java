package com.example.demo.dao.daoImpl;

import com.example.demo.dao.Dao;
import com.example.demo.model.User;
import com.example.demo.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements Dao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(String email, String password) {
        String sql = "SELECT email, password FROM user WHERE email = :email AND password = :password";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        params.addValue("password", password);

        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User createUser(String email, String password) {
        String sql = "INSERT INTO user (email, password) VALUES (:email, :password)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        params.addValue("password", password);

        try {
            namedParameterJdbcTemplate.update(sql, params);
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(password);
            return newUser;
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User checkUser(String email) { /* though only search for single column, still have to select all table*/
        String sql = "SELECT * FROM user WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);

        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
