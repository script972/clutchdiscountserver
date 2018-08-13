package com.script972.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.script972.components.CloudStorageHepler;
import com.script972.components.UserProvider;
import com.script972.dto.GoogleOathDTO;
import com.script972.dto.RegistrationUserDTO;
import com.script972.dto.TokenDTO;
import com.script972.dto.UserDTO;
import com.script972.entity.User;
import com.script972.entity.UserTokenState;
import com.script972.enums.TypePhotoPath;
import com.script972.repository.UserRRepository;
import com.script972.repository.UserRepository;
import com.script972.security.TokenHelper;
import com.script972.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
    TokenHelper tokenHelper;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public boolean isExistingByUsername(String username)  throws UsernameNotFoundException {
        if(username==null)
            throw new UsernameNotFoundException("User name parametr passed.");
        return findByUsername(username) != null;
    }

    @Override
    public UserDTO persistUser(RegistrationUserDTO registrationUserDTO) {
        User user=new User(registrationUserDTO);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
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

    @Override
    public UserTokenState registrationViaGoogle(TokenDTO token, Device device) {
        GoogleOathDTO googleOathDTO = getAccountFromGoogle(token.getToken());
        System.out.println("GOOGLE="+googleOathDTO);
        RegistrationUserDTO registrationUserDTO = new RegistrationUserDTO(googleOathDTO);
        registrationUserDTO.setGooglePlus(true);

        this.persistUser(registrationUserDTO);


        String jws = tokenHelper.generateToken( registrationUserDTO.getUsername(), device);
        int expiresIn = tokenHelper.getExpiredIn(device);
        // Return the token
        return new UserTokenState(jws, expiresIn);

    }

    /**
     * Google token request
     *
     * @param token
     * @return
     */
    private GoogleOathDTO getAccountFromGoogle(String token) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpGet request = new HttpGet("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+token);
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
            System.out.println("HZ="+builders.toString());
            GoogleOathDTO googleResult = gson.fromJson(builders.toString(), GoogleOathDTO.class);
            return googleResult;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
