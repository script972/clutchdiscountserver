package com.script972.service.impl;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.script972.components.DeviceProvider;
import com.script972.dao.CustomUser;
import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.User;
import com.script972.entity.UserTokenState;
import com.script972.exception.AccaountException;
import com.script972.exception.BaseAuthException;
import com.script972.exception.ErrorCode;
import com.script972.mappers.UserMappers;
import com.script972.repository.UserRepository;
import com.script972.security.TokenHelper;
import com.script972.security.auth.JwtAuthenticationRequest;
import com.script972.service.AuthenticationService;
import com.script972.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by script972
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AccountUserDetailsService accountUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceProvider deviceProvider;

    @Override
    public UserTokenState loginUser(JwtAuthenticationRequest authenticationRequest, Device device) {
        final Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword());
        UserDetails userEntity = userService.findByEmail(authenticationRequest.getEmail());
        if (!passwordEncoder.matches(authenticationRequest.getPassword(), userEntity.getPassword())) {
            throw new BaseAuthException(ErrorCode.ACCESS_DENIED);
        }
        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // token creation
        String jws = tokenHelper.generateToken(userEntity.getUsername(), device);
        int expiresIn = tokenHelper.getExpiredIn(device);
        return new UserTokenState(jws, expiresIn);
    }

    @Override
    public UserTokenState facebookUser(String accessToken, Device device) {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        CustomUser userFacebook = facebookClient.fetchObject("me", CustomUser.class,
                Parameter.with("fields",
                        "id, name, email, first_name, last_name"));
        User userDb;
        if (userRepository.findByFacebookid(userFacebook.getId()) == null) {
            userDb = userRepository.save(UserMappers.mapFacebookToUser(userFacebook));
        } else {
            userDb = userRepository.findByFacebookid(userFacebook.getId());
        }

        final Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        userDb.getId(),
                        userDb.getPassword());
        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // token creation
        Long userEntity = (Long) authentication.getPrincipal();
        String jws = tokenHelper.generateToken(String.valueOf(userEntity), device);
        int expiresIn = tokenHelper.getExpiredIn(device);
        return new UserTokenState(jws, expiresIn);
    }

    @Override
    public UserDtoResponce persistUser(RegistrationStepOneUserDtoRequest registrationUserDTO) {
        User user = UserMappers.userDtoToEntity(registrationUserDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userService.isExistingByEmail(registrationUserDTO.getEmail())) {
            throw new AccaountException(ErrorCode.THE_SAME_DATA_ALREADY_CONSIST);

        }
        return UserMappers.userEntityToDto(this.userRepository.save(user));

    }

    @Override
    public UserTokenState refreshAuthenticationToken(HttpServletRequest request, Principal principal) {
        String authToken = tokenHelper.getToken(request);
        Device device = deviceProvider.getCurrentDevice(request);

        if (authToken != null && principal != null) {
            String refreshedToken = tokenHelper.refreshToken(authToken, device);
            int expiresIn = tokenHelper.getExpiredIn(device);
            return new UserTokenState(refreshedToken, expiresIn);
        }else {
            return null;
        }
    }
}
