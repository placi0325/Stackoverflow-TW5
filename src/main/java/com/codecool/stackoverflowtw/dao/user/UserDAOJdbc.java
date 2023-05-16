package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOJdbc implements UserDAO{
    private JdbcTemplate jdbcTemplate;
    private UserMapper userMapper;

    public UserDAOJdbc(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(String name, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?);";
        jdbcTemplate.update(query, name, password);
        System.out.println("New user created.");
    }

    @Override
    public List<User> listAllUsers() {
        String query = "SELECT * FROM users;";
        List<User> users = jdbcTemplate.query(query, userMapper);
        return users;
    }

    @Override
    public User getById(int id) {
        String query = "SELECT * FROM users WHERE id=" + id;
        return jdbcTemplate.query(query, userMapper).get(0);
    }

    @Override
    public void updateUsername(String newUsername) {

    }

    @Override
    public void updatePassword(String password) {

    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
