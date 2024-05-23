package com.example.opa.services;

import com.example.opa.dao.UserDao;
import com.example.opa.entity.User;
import com.example.opa.opa.OpaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private UserDao dao;
    private static User user;

    public UserServicesImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void login(String email) {
        user = dao.findByEmail(email);
        System.out.println("\n--------------------------\n");
        System.out.println("current user: "+user.getFirstName()+" "+user.getLastName());
        System.out.println("role: "+user.getRole());
        System.out.println("\n--------------------------\n");
    }

    @Override
    public User getAccountInfo() {
        return user;
    }

    @Override
    public User getUser(String email) {
        if(OpaService.isAllowed(user)) return dao.findByEmail(email);
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        if(OpaService.isAllowed(user)) return dao.findAll();
        return null;
    }
}
