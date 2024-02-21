package com.tmr.bookseller.service;

import com.tmr.bookseller.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    void makeAdmin(String username);
}
