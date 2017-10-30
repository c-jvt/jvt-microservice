package com.jvt.microservice.api.core.oauth;


import com.jvt.microservice.domain.Admin;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdminDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String id) {
        Admin admin = new Admin();
        admin.setName("张三");
        admin.setPwd("123456");
        if (admin == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(admin.getName(),
                admin.getPwd(), authorities);
    }
}
