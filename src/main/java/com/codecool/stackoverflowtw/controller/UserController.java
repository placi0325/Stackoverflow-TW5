package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.LoginDTO;
import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public int addNewUser(@RequestBody NewUserDTO newUser){
        return userService.addNewUser(newUser);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO loginDTO){
        String username = loginDTO.username();
        String password = loginDTO.password();

        UserDTO userFromDatabase = userService.getUserByName(username);
        if(userFromDatabase != null){
            if(password.equals(userFromDatabase.password())){
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id){
        return userService.deleteUserById(id);
    }
}
