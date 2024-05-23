package com.example.opa.controller;

import com.example.opa.entity.User;
import com.example.opa.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/login")
    public void login(@RequestParam("email") String email) {
        userServices.login(email);
    }

    @GetMapping("/account")
    public User getUserInfo() {
        return userServices.getAccountInfo();
    }

    @GetMapping("/")
    public Object getAll() {
        List<User> users = userServices.getAllUsers();
        if(users==null) {
            return "Not Authorized !";
        }
        return users;
    }

    @GetMapping("/{email}")
    public Object getUser(@PathVariable("email") String email) {
        User user = userServices.getUser(email);
        if(user==null) {
            return "Not Authorized !";
        }
        return user;
    }
}
