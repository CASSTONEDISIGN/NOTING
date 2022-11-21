package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;


public class TestController {
    @GetMapping("")
    public String getTest(){
        return "build/resources/main/static/index.html";
    }
}
