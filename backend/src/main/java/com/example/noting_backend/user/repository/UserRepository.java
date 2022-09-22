package com.example.noting_backend.user.repository;

import com.example.noting_backend.user.entity.User;

import java.util.Optional;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findUser(User user);
}
