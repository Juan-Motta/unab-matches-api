package com.matches.services;

import com.matches.entities.User;

import java.util.List;

public interface UserServiceInterface {

    public User saveUser(User user) throws Exception;

    public User getUser(String username);

    public List<User> getAllUser();

}
