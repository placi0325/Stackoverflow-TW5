package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    int createUser(String name, String password);
    List<User> listAllUsers();
    Optional<User> getById(int id);
    void updateUsername(String oldUserName, String newUsername);
    void updatePassword(String username ,String password);
    boolean deleteById(int id);
}
