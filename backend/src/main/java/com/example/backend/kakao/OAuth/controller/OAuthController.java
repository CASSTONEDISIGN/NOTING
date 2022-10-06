package com.example.backend.kakao.OAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oauth")
public class OAuthController {

    @ResponseBody
    @GetMapping("/kakao")
    public void callBack(@RequestParam String code){

    }



}
