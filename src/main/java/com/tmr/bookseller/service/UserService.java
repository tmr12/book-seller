package com.tmr.bookseller.service;

import com.tmr.bookseller.model.Role;
import com.tmr.bookseller.model.User;
import com.tmr.bookseller.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    Optional<User> findByUserName(String username) {
        return  userRepository.findByUserName(username);
    }
    public void makeAdmin(String username) {
        userRepository.updateUserRole(username, Role.ADMIN);
    }


}
