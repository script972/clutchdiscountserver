package com.script972.mappers;

import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.User;
import com.script972.dao.CustomUser;

/**
 * Created by script972
 */

public class UserMappers {

    public static UserDtoResponce userEntityToDto(User entity) {
        UserDtoResponce dto = new UserDtoResponce();

        return dto;
    }

    public static User userDtoToEntity(RegistrationStepOneUserDtoRequest entity) {
        User db = new User();
        db.setPassword(entity.getPassword());
        db.setEmail(entity.getEmail());
        return db;
    }

    public static User mapFacebookToUser(CustomUser user) {
        User db = new User();
        db.setEmail(user.getEmail());
        db.setFirstName(user.getFirstName());
        db.setLastName(user.getLastName());
        db.setFacebookid(user.getId());
        return db;
    }
}
