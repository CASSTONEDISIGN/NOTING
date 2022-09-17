package com.example.noting_backend.user.service;

import com.example.noting_backend.user.entity.User;
import lombok.RequiredArgsConstructor;
import com.example.noting_backend.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User join(User user) {
        validateDuplicateMember(user);
        userRepository.save(user);
        return user;
    }

    private void validateDuplicateMember(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    @Override
    public Optional<User> login(String id, String pw) {
        return Optional.empty();
    }

    @Override
    public Optional<User> login(User user) {
        return userRepository.finduser(user);
    }
}
