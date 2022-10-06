package com.example.backend.user.repository;

import java.util.Optional;
import com.example.backend.user.entity.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findUser(User user);
    Optional<User> changePw(User user, String newpw);
}
