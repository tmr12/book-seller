package com.tmr.bookseller.repository;

import com.tmr.bookseller.model.Role;
import com.tmr.bookseller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository  extends JpaRepository<User, Long> {


    Optional<User> findByUserName(String username);
    @Modifying
    @Query("update User set role = : role where username = : username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);
}
