package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(String name, String password);
    List<User> listAllUsers();
    User getById(int id);
    void updateUsername(String newUsername);
    void updatePassword(String password);
    boolean deleteById(int id);
}
