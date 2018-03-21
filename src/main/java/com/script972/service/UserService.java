package com.script972.service;

import com.script972.entity.User;

import java.util.List;

/**
 * Created by script972
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
