package com.script972.service;

import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.UserTokenState;
import com.script972.security.auth.JwtAuthenticationRequest;
import org.springframework.mobile.device.Device;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by script972
 */

public interface AuthenticationService {

    UserTokenState loginUser(JwtAuthenticationRequest authenticationRequest, Device device);

    UserTokenState facebookUser(String accessToken, Device device);

    UserDtoResponce persistUser(RegistrationStepOneUserDtoRequest registrationUserDTO);

    UserTokenState refreshAuthenticationToken(HttpServletRequest request, Principal principal);
}
