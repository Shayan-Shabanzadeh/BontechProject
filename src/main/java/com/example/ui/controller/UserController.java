package com.example.ui.controller;

import com.example.io.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path = "/{userId}}" , produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@PathVariable long userId){
        return userService.getUser(userId);
    }
    @DeleteMapping(path = "/{userId}}")
    void removeUserById(@PathVariable long userId){
         userService.deleteUser(userId);
    }
    @PostMapping(path = "/" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    User insertUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping(path = "/" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@RequestBody User user){
        userService.updateUser(user);
        return user;
    }


}
