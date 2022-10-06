package com.example.backend.user.repository;

<<<<<<< Updated upstream:backend/src/main/java/com/example/noting_backend/user/repository/UserRepository.java
import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;

import java.util.Optional;
=======
import com.example.backend.user.entity.User;
>>>>>>> Stashed changes:backend/src/main/java/com/example/backend/user/repository/UserRepository.java

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findUser(User user);
    Optional<User> changePw(User user, String newpw);
}
