package com.example.noting_backend.user.service;

import com.example.noting_backend.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import com.example.noting_backend.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserEntity join(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }

//    public UserData join(UserData userData) {
//        return null;
//    }




    @Override
    public Optional<UserEntity> login(String id, String pw) {
        return Optional.empty();
    }
}
