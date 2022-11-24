package com.example.backend.map.controller;

import com.example.backend.map.service.KakaoMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class KakaoMapController {

    private final KakaoMapService kakaoMapService;

    @GetMapping("/category")
    public void kakaoMap(@RequestParam String x, @RequestParam String y) {

        // 교통대 127.87179754134 36.967257621809
        // 터미널 127.9150263161 36.981136495916
        // 임피리얼 팰리스 서울 127.035902 37.514132

        kakaoMapService.getStoreByCategory(x, y);
    }
}
