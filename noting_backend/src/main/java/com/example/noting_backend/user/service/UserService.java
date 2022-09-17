package com.example.noting_backend.user.service;

import com.example.noting_backend.user.entity.User;

import java.util.Optional;

public interface UserService {
    User join(User user);
    Optional<User> login(String id, String pw);
}
