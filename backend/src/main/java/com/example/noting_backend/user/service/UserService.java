package com.example.noting_backend.user.service;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;

import java.util.Optional;

public interface UserService {
    User join(UserDto userdto) throws Exception;

    Optional<com.example.noting_backend.user.entity.User> login(String id, String pw);
    Optional<com.example.noting_backend.user.entity.User> login(com.example.noting_backend.user.entity.User user);

}
