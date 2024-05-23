package com.example.opa.services;

import com.example.opa.entity.User;

import java.util.List;

public interface UserServices {
    void login(String email);
    User getAccountInfo();
    User getUser(String email);
    List<User> getAllUsers();
}
