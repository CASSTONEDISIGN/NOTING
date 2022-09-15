package com.example.noting_backend.user.controller;

import com.example.noting_backend.user.entity.UserEntity;
import com.example.noting_backend.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/Join")
    public String createUser(@RequestBody UserEntity userEntity){
        userService.join(userEntity);
        return "성공";
    }

    @PostMapping("/Login")
    public void login(@RequestParam String id, @RequestParam String pw){

    }
}
