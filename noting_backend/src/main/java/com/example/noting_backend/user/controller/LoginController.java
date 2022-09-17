package com.example.noting_backend.user.controller;

import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.service.UserService;
import com.example.noting_backend.user.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final SessionManager sessionManager;

    @PostMapping("/login")
    public void loginV2(@Validated @RequestBody User user, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            System.out.println("hasError");
        }
        Optional<User> loginMember = userService.login(user);

        if (loginMember.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            System.out.println("Empty");
        }

        sessionManager.createSession(loginMember, response);
        System.out.println("성공");
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        sessionManager.expires(request);
        return "로그아웃";
    }
}
