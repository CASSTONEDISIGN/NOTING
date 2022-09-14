package com.example.noting_backend.service;

import com.example.noting_backend.dto.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.noting_backend.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;
    @Override
    public UserData join(UserData userData) {
        return null;
    }

    @Override
    public Optional<UserData> Login(String id, String pw) {
        return Optional.empty();
    }
}
