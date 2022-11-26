package com.example.backend.map.controller;

import com.example.backend.map.service.KakaoMapService;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KakaoMapControllerTest {

    @Autowired
    KakaoMapService kakaoMapService;

    @Test
    void sendAll() {
        JSONArray all = kakaoMapService.getAll();
        System.out.println("all = " + all);
    }
}