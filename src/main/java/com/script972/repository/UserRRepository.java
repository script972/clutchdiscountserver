package com.script972.repository;

import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;

public interface UserRRepository {

    void addNewUser(User userDTO);

    void updateUserName(User user);

    User getPhoneNumber(String number);
}