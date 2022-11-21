package com.example.backend.user.controller;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.service.UserService;
import com.example.backend.user.session.SessionManager;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final SessionManager sessionManager;

    @PostMapping("/signup")
    public void signUp(@RequestBody UserDto userDto) throws Exception {
        userService.join(userDto);
    }


    @PostMapping("/signin")
    @ResponseBody
    public Optional<User> signin(@RequestBody UserDto userDto) throws Exception {
        Optional<User> loginMember = userService.login(userDto);

        if (loginMember.isEmpty()) {
            System.out.println("Empty");
        }


        System.out.println("성공");

        return loginMember;
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        sessionManager.expires(request);
        return "로그아웃";
    }
}
