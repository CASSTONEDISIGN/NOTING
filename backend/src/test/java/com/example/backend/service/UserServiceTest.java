package com.example.backend.service;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.hash.UserHash;
import com.example.backend.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
                .email("spring@gmail.com")
                .pw("43b18f766ed1ab354fda1b6288e408d9a2292265fee1ef324b5ba86d9ea08315")
                .build();

        User result = userService.join(userdto);

        assertThat(userdto.getEmail()).isEqualTo(result.getEmail());
        System.out.println(result);
    }

    @Test
    public void 중복회원() throws Exception {
        UserDto userDto1 = UserDto.builder()
                .email("spring@gmail.com")
                .pw("43b18f766ed1ab354fda1b6288e408d9a2292265fee1ef324b5ba86d9ea08315").build();

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
        UserDto userDto = UserDto.builder()
                .email("spring@gmail.com")
                .pw("43b18f766ed1ab354fda1b6288e408d9a2292265fee1ef324b5ba86d9ea08315").build();

        Optional<User> result = userService.login(userDto);

        System.out.println(result.get().toString());
        assertThat(userDto.getEmail()).isEqualTo(result.get().getEmail());
    }

    @Test
    public void 비밀번호변경() throws Exception{
        UserDto userDto = UserDto.builder()
                .email("spring@gmail.com")
                .pw("spring").build();

        Optional<User> result = userService.change(userDto,"spring2");
    }

    @Test
    public void 해시중복() throws Exception {
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
    @Test
    public void 해시() throws Exception {
        UserDto userDto = UserDto.builder()
                .id(4L)
                .email("saqw@gmail.com")
                .pw("1234")
                .createAt(LocalDateTime.parse("2022-10-27 14:46:17"))
                .build();

        UserHash userHash = new UserHash();

        String hash = userHash.hash(userDto);

        System.out.println("hash = " + hash);
    }
}
