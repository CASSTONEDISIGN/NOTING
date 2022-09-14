package com.example.noting_backend.repository;


import com.example.noting_backend.dto.UserData;

import java.util.Optional;

public interface UserRepository {
    Optional<UserData> FindForLogin(String id, String pw);
    UserData save(UserData userData);
}
