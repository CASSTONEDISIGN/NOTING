package com.example.backend.user.service;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;

import java.util.Optional;

public interface UserService {
    User join(UserDto userdto) throws Exception;

    Optional<com.example.backend.user.entity.User> login(String id, String pw);
    Optional<com.example.backend.user.entity.User> login(com.example.backend.user.entity.User user);

}
