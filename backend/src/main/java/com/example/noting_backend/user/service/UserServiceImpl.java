package com.example.noting_backend.user.service;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.hash.UserHash;
import lombok.RequiredArgsConstructor;
import com.example.noting_backend.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserHash userHash;

    @Override
    public User join(UserDto userDto) throws Exception {
        String SALT = userHash.getSALT(userDto);
        String hashedPw = userHash.hashing(userDto.getPw().getBytes(), SALT);

        userDto.setPw(hashedPw);
        User user = userDto.toEntity();

        validateDuplicateMember(user);
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<com.example.noting_backend.user.entity.User> login(String id, String pw) {
        return Optional.empty();
    }

    @Override
    public Optional<com.example.noting_backend.user.entity.User> login(com.example.noting_backend.user.entity.User user) {
        return userRepository.findUser(user);
    }

    private void validateDuplicateMember(com.example.noting_backend.user.entity.User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
