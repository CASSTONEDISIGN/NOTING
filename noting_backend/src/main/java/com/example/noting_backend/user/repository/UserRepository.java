package com.example.noting_backend.user.repository;

import com.example.noting_backend.user.entity.UserEntity;

public interface UserRepository {
//    Optional<UserEntity> FindForLogin(String id, String pw);
//    UserData save(UserData userData);
    UserEntity save(UserEntity userEntity);
}
