package com.example.noting_backend.user.service;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserService {
    User join(UserDto userdto) throws Exception;
    Optional<User> login(UserDto userDto) throws Exception;
    Optional<User> change(UserDto userDto, String newpw) throws Exception;
    LocalDateTime getCreateTime(UserDto userDto);
}
