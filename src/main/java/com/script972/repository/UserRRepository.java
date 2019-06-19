package com.script972.repository;

import com.script972.entity.User;

public interface UserRRepository {

    void addNewUser(User userDTO);

    void updateUserName(User user);

    User getPhoneNumber(String number);

    boolean addPhotoAvatar(Long id, String url);
}
