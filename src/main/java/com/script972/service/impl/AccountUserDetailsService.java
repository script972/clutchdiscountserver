package com.script972.service.impl;

import com.script972.entity.User;
import com.script972.exception.BaseAuthException;
import com.script972.exception.ErrorCode;
import com.script972.repository.UserRepository;
import com.script972.security.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by script972
 */

@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long accontId = Long.valueOf(username);
        User user = userRepository.findById(accontId);
        if (user == null){
            throw new BaseAuthException(ErrorCode.UNEXPECTED_STATE);
        }
        return new AccountDetails(user);
    }
}
