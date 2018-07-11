package com.script972.service.impl;

import com.script972.components.CloudStorageHepler;
import com.script972.components.UserProvider;
import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;
import com.script972.enums.TypePhotoPath;
import com.script972.repository.UserRRepository;
import com.script972.repository.UserRepository;
import com.script972.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by script972
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRRepository registration;
    @Autowired
    private CloudStorageHepler cloudStorageHelper;
    @Autowired
    private UserProvider userProvider;


    @Override
    public User findByUsername( String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    public User findById( Long id ) throws AccessDeniedException {
        User u = userRepository.findOne( id );
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public boolean isExistingByUsername(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public UserDTO persistUser(RegistrationUserDTO registrationUserDTO) {
        User user=new User(registrationUserDTO);
        if (!this.isExistingByUsername(registrationUserDTO.getUsername())) {
            this.registration.addNewUser(user);
            User u=userRepository.findByUsername(registrationUserDTO.getUsername());
            return new UserDTO(u);
        }else{
            return null;
        }

    }

    @Override
    public UserDTO personalInfo(RegistrationUserDTO registrationUserDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user=(User)authentication.getPrincipal();
            user.setRegistrationUser(registrationUserDTO);
            this.registration.updateUserName(user);
            return new UserDTO(this.findById(user.getId()));
        }
        return null;

    }

    @Override
    public List<UserDTO> getByPhoneNumber(String phonenumber) {
        String [] numbers=phonenumber.split("&");
        List<UserDTO> list=new ArrayList<>();
        for (String number : numbers) {
            User user = this.registration.getPhoneNumber(number);
            if (user != null)
                list.add(new UserDTO(user));
        }
        return list;
    }

    @Override
    public String uploadPhotoFace(MultipartFile file) throws IOException {
        String url = cloudStorageHelper.uploadFile(file, TypePhotoPath.USER_PHOTO);
        User user = userProvider.getCurrentUser();
        if(user == null)
            return null;
        if(!registration.addPhotoAvatar(user.getId(), url))
            return null;

        return url;
    }


}
