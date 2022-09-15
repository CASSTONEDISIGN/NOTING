package com.example.noting_backend.user.service;

import com.example.noting_backend.user.entity.UserEntity;

import java.util.Optional;

public interface UserService {
//    UserData join(UserData userData);
    UserEntity join(UserEntity userEntity);
    Optional<UserEntity> login(String id, String pw);
}
