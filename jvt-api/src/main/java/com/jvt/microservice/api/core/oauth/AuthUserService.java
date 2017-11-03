package com.jvt.microservice.api.core.oauth;

import com.jvt.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthUserService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) {
        com.jvt.microservice.domain.User user = userService.getInfoByAccount(account);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new com.jvt.microservice.api.core.oauth.AuthUser(user.getCode(),
                user.getPwd(), user.getSalt(), authorities);
    }
}