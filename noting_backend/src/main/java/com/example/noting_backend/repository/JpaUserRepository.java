package com.example.noting_backend.repository;

import com.example.noting_backend.dto.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final EntityManager em;

    @Override
    public Optional<UserData> FindForLogin(String id, String pw) {
        return Optional.empty();
    }

    @Override
    public UserData save(UserData userData) {
        return null;
    }
}
