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

    }

    @Override
    public List<User> listAllUsers() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
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
