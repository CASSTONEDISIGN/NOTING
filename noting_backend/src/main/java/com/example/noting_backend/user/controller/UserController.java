package com.example.noting_backend.user.controller;

import com.example.noting_backend.user.entity.User;
import com.example.noting_backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/Join")
    public String createUser(@RequestBody User user){
        userService.join(user);
        return "성공";
    }

    @PostMapping("/Login")
    public void login(@RequestParam String id, @RequestParam String pw){

    }
}
