package com.example.noting_backend.service;

import com.example.noting_backend.user.entity.UserEntity;
import com.example.noting_backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void 회원가입(){
        UserEntity user = UserEntity.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        UserEntity result = userService.join(user);

        assertThat(user.getEmail()).isEqualTo(result.getEmail());
    }
}
