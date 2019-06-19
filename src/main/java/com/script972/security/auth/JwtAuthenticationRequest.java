package com.script972.security.auth;

import lombok.Data;

/**
 * Created by script972
 */
@Data
public class JwtAuthenticationRequest {
    private String email;
    private String password;

}
