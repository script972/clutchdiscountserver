package com.script972.rest;

import com.script972.dto.RegistrationStepOneUserDtoRequest;
import com.script972.dto.responce.UserDtoResponce;
import com.script972.entity.UserTokenState;
import com.script972.security.TokenHelper;
import com.script972.security.auth.JwtAuthenticationRequest;
import com.script972.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by script972
 */

@Api(value = "Auth Controller", description = "Rest controller for auth and logout")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private AuthenticationService authService;

    @ApiOperation(value = "Log up in system ", response = UserDtoResponce.class)
    @PostMapping
    public ResponseEntity<UserDtoResponce> registrationUser(@RequestBody RegistrationStepOneUserDtoRequest registrationUserDTO) {
        UserDtoResponce user = this.authService.persistUser(registrationUserDTO);
        return new ResponseEntity(user,
                HttpStatus.OK);

    }

    @ApiOperation(value = "auth in system", response = UserTokenState.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response,
            Device device
    ) throws AuthenticationException {
        // Perform the security
        UserTokenState result = authService.loginUser(authenticationRequest, device);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "auth in via facebook", response = UserTokenState.class)
    @PostMapping(value = "/facebook")
    public ResponseEntity facebookLogin(@RequestParam("token") String accessToken, Device device) {
        return ResponseEntity.ok(authService.facebookUser(accessToken, device));
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<UserTokenState> refreshAuthenticationToken(
            HttpServletRequest request,
            HttpServletResponse response,
            Principal principal
    ) {
        UserTokenState userTokenState = authService.refreshAuthenticationToken(request, principal);
        if (userTokenState != null) {
            return ResponseEntity.ok(userTokenState);
        } else {
            return ResponseEntity.badRequest().body(new UserTokenState());
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
        //userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

    static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
    }
}