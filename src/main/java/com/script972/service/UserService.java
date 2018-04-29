package com.script972.service;

import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;

import java.util.List;

/**
 * Created by script972
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();

    boolean isExistingByUsername(String username);

    UserDTO persistUser(RegistrationUserDTO registrationUserDTO);

    UserDTO personalInfo(RegistrationUserDTO registrationUserDTO);

    List<UserDTO> getByPhoneNumber(String phonenumber);
}
