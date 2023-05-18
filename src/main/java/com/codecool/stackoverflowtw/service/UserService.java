package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.dao.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userDAO.listAllUsers();
        return users.stream().map(user -> convertUserToUserDTO(user)).toList();
    }

    public UserDTO getUserById(int id){
        Optional<User> userById = userDAO.getById(id);
        return  userById.isPresent() ? convertUserToUserDTO(userById.get()) : null;
    }

    public UserDTO getUserByName(String username){
        Optional<User> userByName = userDAO.getByName(username);
        return  userByName.isPresent() ? convertUserToUserDTO(userByName.get()) : null;
    }

    public boolean deleteUserById(int id){
        return userDAO.deleteById(id);
    }

    public int addNewUser(NewUserDTO newUser){
        return userDAO.createUser(newUser.username(), newUser.password());
    }

    public void updateUsername(String oldUserName, String newUsername){
        userDAO.updateUsername(oldUserName, newUsername);
    }

    public void updatePassword(String username, String newPassword){
        userDAO.updatePassword(username, newPassword);
    }

    private UserDTO convertUserToUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
