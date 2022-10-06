package com.example.backend.user.service;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserService {
    User join(UserDto userdto) throws Exception;
    Optional<User> login(UserDto userDto) throws Exception;
    Optional<User> change(UserDto userDto, String newpw) throws Exception;
    LocalDateTime getCreateTime(UserDto userDto);
}
