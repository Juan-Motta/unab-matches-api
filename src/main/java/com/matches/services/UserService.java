package com.matches.services;

import com.matches.entities.User;
import com.matches.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) throws Exception {
        User user_entity = userRepository.findByUsername(user.getUsername());
        if (user_entity != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya existe");
        } else {
            user_entity = userRepository.save(user);
        }
        return user_entity;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
