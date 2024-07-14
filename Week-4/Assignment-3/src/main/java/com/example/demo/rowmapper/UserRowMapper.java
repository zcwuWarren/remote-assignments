package com.example.demo.rowmapper;

import com.example.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();

        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
