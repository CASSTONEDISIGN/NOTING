package com.example.noting_backend.service;

import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    public void 회원가입(){
        User user = User.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        User result = userService.join(user);

        assertThat(user.getEmail()).isEqualTo(result.getEmail());
    }

    @Test
    public void 중복회원(){
        User user1 = User.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        User result1 = userService.join(user1);

        User user2 = User.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(user2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
