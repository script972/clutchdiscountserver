package com.script972.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by script972
 */

@Data
public class UserTokenState {
    private String accessToken;
    private Long expiresIn;

    public UserTokenState() {
    }

    public UserTokenState(String refreshedToken, long expiresIn) {
        this.accessToken = refreshedToken;
        this.expiresIn = expiresIn;
    }
}