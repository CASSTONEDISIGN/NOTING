package com.example.noting_backend.service;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        UserDto userdto = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring")
                .build();

        User result = userService.join(userdto);

        assertThat(userdto.getPw()).isEqualTo(result.getPw());
        System.out.println(result.toString());
    }

    @Test
    public void 중복회원() throws Exception {
        UserDto userDto1 = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        User result1 = userService.join(userDto1);

        UserDto userDto2 = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(userDto2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    @Test
    public void 로그인(){
        com.example.noting_backend.user.entity.User user = com.example.noting_backend.user.entity.User.builder()
                .email("asd")
                .pw("ddd").build();

        Optional<com.example.noting_backend.user.entity.User> result = userService.login(user);

        assertThat(user.getEmail()).isEqualTo(result.get().getEmail());
    }
}
