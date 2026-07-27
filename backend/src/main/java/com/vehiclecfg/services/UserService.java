package com.vehiclecfg.services;

import java.util.List; 

import com.vehiclecfg.entities.User;

public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);

    User getByUsername(String username);
}