package com.script972.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.script972.components.CloudStorageHepler;
import com.script972.components.UserProvider;
import com.script972.dto.GoogleOathDTO;
import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.User;
import com.script972.mappers.UserMappers;
import com.script972.repository.UserRRepository;
import com.script972.repository.UserRepository;
import com.script972.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User findByEmail(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findOne(id);
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }

    @Override
    public boolean isExistingByEmail(String username) {
        return findByEmail(username) != null;
    }

    @Override
    public UserDtoResponce personalInfo(RegistrationStepOneUserDtoRequest registrationUserDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     /*   if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
//            user.setRegistrationUser(registrationUserDTO);
            this.registration.updateUserName(user);
            return new UserDtoResponce(this.findById(user.getId()));
        }*/
        return null;

    }

    @Override
    public List<UserDtoResponce> getByPhoneNumber(String phonenumber) {
        String[] numbers = phonenumber.split("&");
        List<UserDtoResponce> list = new ArrayList<>();
        for (String number : numbers) {
            User user = this.registration.getPhoneNumber(number);
            if (user != null)
                list.add(UserMappers.userEntityToDto(user));
        }
        return list;
    }

    @Override
    public String uploadPhotoFace(MultipartFile file) throws IOException {
        String url = cloudStorageHelper.uploadFile(file);
        User user = userProvider.getCurrentUser();
        if (user == null)
            return null;
        if (!registration.addPhotoAvatar(user.getId(), url))
            return null;

        return url;
    }

    /**
     * Try to get information from google by token
     *
     * @param token
     * @return
     */
    private GoogleOathDTO getAccountFromGoogle(String token) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&accessToken=" + token);
            HttpResponse response = client.execute(request);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builders = new StringBuilder();

            String line;
            while ((line = bufReader.readLine()) != null) {
                builders.append(line);
                builders.append(System.lineSeparator());
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            GoogleOathDTO googleResult = gson.fromJson(builders.toString(), GoogleOathDTO.class);
            return googleResult;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
