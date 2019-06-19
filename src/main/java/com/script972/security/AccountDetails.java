package com.script972.security;

import com.script972.entity.Authority;
import com.script972.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by script972
 */

@lombok.Getter
@lombok.Setter
public class AccountDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private User account;

    public AccountDetails(User account) {
        username = account.getId().toString();
        password = account.getPassword();
        this.authorities = account.getAuthorities();
        enabled = true;
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        this.account = account;
    }

    public Date getLastPasswordResetDate() {
        return account.getLastPasswordResetDate();
    }
}
