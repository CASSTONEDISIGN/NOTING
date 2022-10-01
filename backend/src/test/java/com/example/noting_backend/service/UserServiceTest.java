package com.example.noting_backend.service;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.hash.UserHash;
import com.example.noting_backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
//@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        UserDto userdto = UserDto.builder()
                .email("saqw@gmail.com")
                .pw("1234")
                .build();

        User result = userService.join(userdto);

        assertThat(userdto.getPw()).isEqualTo(result.getPw());
        System.out.println(result);
    }

    @Test
    public void 중복회원() throws Exception {
        UserDto userDto1 = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        userService.join(userDto1);

        UserDto userDto2 = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(userDto2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    @Test
    public void 로그인() throws Exception {
        UserDto user = UserDto.builder()
                .email("sa@gmail.com")
                .pw("aaaa").build();

        Optional<User> result = userService.login(user);

        System.out.println(result.get().getPw());
        assertThat(user.getEmail()).isEqualTo(result.get().getEmail());
    }

    @Test
    public void 비밀번호변경() throws Exception{
        UserDto userdto = new UserDto();
        userdto.setEmail("sa@gmail.com");
        userdto.setPw("1234");
        //98fd82e58c7854df98a398af0b4e6bb757749626b7e3c3b5e87a080e2e2befe5

        Optional<User> result = userService.change(userdto,"aaaa");

    }

    @Test
    public void 해시() throws Exception {
        UserDto userDto1 = UserDto.builder()
                .id(1L)
                .email("spring1@gmail.com")
                .pw("spring1")
                .build();

        UserDto userDto2 = UserDto.builder()
                .id(2L)
                .email("spring2@gmail.com")
                .pw("spring2")
                .build();

        UserHash userHash = new UserHash();

        String hash1 = userHash.hash(userDto1);
        String hash2 = userHash.hash(userDto2);

        System.out.println("hash1 = " + hash1);
        System.out.println("hash2 = " + hash2);

        assertThat(hash1).isNotEqualTo(hash2);
    }
}
