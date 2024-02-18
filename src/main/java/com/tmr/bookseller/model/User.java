package com.tmr.bookseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name="username", unique = true, nullable = false, length = 100)
    String username;
    @Column(name = "password", nullable = false, length = 100)
    String password;
    @Column(name = "name", nullable = false, length = 100)
    String name;
    @Column(name = "create_time", nullable = false)
    LocalDateTime createTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    Role role;
}
