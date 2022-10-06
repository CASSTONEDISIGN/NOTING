package com.example.backend.user.controller;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.service.UserService;
import com.example.backend.user.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionManager sessionManager;

    @PostMapping("/join")
    public String createUser(@RequestBody UserDto userDto) throws Exception {
        userService.join(userDto);
        return "성공";
    }

    @PostMapping("/login")
    public void loginV2(@Validated @RequestBody UserDto userDto, BindingResult bindingResult, HttpServletResponse response) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println("hasError");
        }
        Optional<User> loginMember = userService.login(userDto);

        if (loginMember.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            System.out.println("Empty");
        }

        sessionManager.createSession(loginMember, response);
        System.out.println("성공");
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        sessionManager.expires(request);
        return "로그아웃";
    }
}
