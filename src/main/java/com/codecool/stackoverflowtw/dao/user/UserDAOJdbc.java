package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserDAOJdbc implements UserDAO{
    private JdbcTemplate jdbcTemplate;
    private UserMapper userMapper;

    public UserDAOJdbc(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public int createUser(String name, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?);";
        int rowsAffected = jdbcTemplate.update(query, name, password);
        System.out.println("Affected rows: " + rowsAffected);
        System.out.println("New user created.");
        return rowsAffected;
    }

    @Override
    public List<User> listAllUsers() {
        String query = "SELECT * FROM users;";
        List<User> users = jdbcTemplate.query(query, userMapper);
        return users;
    }

    @Override
    public Optional<User> getById(int id) {
        String query = "SELECT * FROM users WHERE id=" + id;
        return jdbcTemplate.query(query, userMapper).stream().findFirst();
    }

    @Override
    public Optional<User> getByName(String username) {
        String query = "SELECT * FROM users WHERE username = " + username;
        return jdbcTemplate.query(query, userMapper).stream().findFirst();
    }

    @Override
    public void updateUsername(String oldUsername, String newUsername) {
        String query = String.format("UPDATE users SET username = %s WHERE username = %s", oldUsername, newUsername);
        int rowsAffected = jdbcTemplate.update(query);
        System.out.println("Affected rows: " + rowsAffected);
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        String query = String.format("UPDATE users SET password = %s WHERE username = %s", newPassword, username);
        int rowsAffected = jdbcTemplate.update(query);
        System.out.println("Affected rows: " + rowsAffected);
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM users WHERE id = " + id;
        return jdbcTemplate.update(query) == 1;
    }
}
