package com.script972.service;

import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by script972
 */
public interface UserService {
    User findById(Long id);
    User findByEmail(String username);
    List<User> findAll ();

    boolean isExistingByEmail(String username);

    UserDtoResponce personalInfo(RegistrationStepOneUserDtoRequest registrationUserDTO);

    List<UserDtoResponce> getByPhoneNumber(String phonenumber);

    String uploadPhotoFace(MultipartFile file) throws IOException;

}
