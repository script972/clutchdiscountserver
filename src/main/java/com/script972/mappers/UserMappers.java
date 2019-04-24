package com.script972.mappers;

import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;

/**
 * Created by script972
 */

public class UserMappers {

    public static UserDTO userEntityToDto(User entity) {
        UserDTO dto = new UserDTO();

        return dto;
    }

    public static User userDtoToEntity(RegistrationUserDTO entity) {
        User db = new User();

        return db;
    }
}
