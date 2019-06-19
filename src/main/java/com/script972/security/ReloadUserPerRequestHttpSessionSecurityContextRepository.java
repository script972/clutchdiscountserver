package com.script972.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import java.util.Collection;

/**
 * Created by script972
 */

public class ReloadUserPerRequestHttpSessionSecurityContextRepository extends HttpSessionSecurityContextRepository {


    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext context = super.loadContext(requestResponseHolder);

        Authentication authentication = context.getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                /*if (authority.getAuthority().contains(Authorities.NOT_VERIFIED_SUFFIX)) {
                    authorizationService.reauthorize(context);
                    break;
                }*/
            }
        }
        return context;
    }
}
