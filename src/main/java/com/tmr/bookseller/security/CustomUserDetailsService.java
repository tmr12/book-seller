package com.tmr.bookseller.security;

import com.tmr.bookseller.model.User;
import com.tmr.bookseller.service.IUserService;
import com.tmr.bookseller.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtil.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
