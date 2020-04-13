package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRespoitory userRespoitory;

    public void addUser(User user){
        userRespoitory.save(user);
    }
    public void updateUser(User user){
        userRespoitory.save(user);
    }
    public void deleteUser(Long id){
        userRespoitory.deleteById(id);
    }
    public Optional<User> getUser(Long id){
        return userRespoitory.findById(id);
    }
}
