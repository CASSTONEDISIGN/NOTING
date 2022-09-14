package com.example.noting_backend.service;

import com.example.noting_backend.dto.UserData;

import java.util.Optional;

public interface UserService {
    UserData join(UserData userData);
    Optional<UserData> Login(String id, String pw);
}
