package com.example.backend.user.controller;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.service.UserService;
import com.example.backend.user.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionManager sessionManager;

    @RequestMapping("signup")
    public void signUp(@RequestBody UserDto userDto) throws Exception {
        userService.join(userDto);
    }

    @PostMapping("/login")
    public void login(@Validated @RequestParam String email, @RequestParam String pw, BindingResult bindingResult, HttpServletResponse response) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setPw(pw);

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

    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        sessionManager.expires(request);
        return "로그아웃";
    }
}
