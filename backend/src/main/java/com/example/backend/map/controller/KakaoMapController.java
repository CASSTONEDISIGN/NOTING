package com.example.backend.map.controller;

import com.example.backend.map.dto.Level;
import com.example.backend.map.service.KakaoMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequiredArgsConstructor
@Slf4j
public class KakaoMapController {

    private final KakaoMapService kakaoMapService;
    private final Level level;

    @GetMapping("/category")
    public void kakaoMap(@RequestParam String x, @RequestParam String y) {

        // 교통대 127.87179754134 36.967257621809
        // 터미널 127.9150263161 36.981136495916
        // 임피리얼 팰리스 서울 127.035902 37.514132

        kakaoMapService.kakaoApi(x, y);
    }

    @GetMapping("/map")
    public JSONArray sendStoreByXY(@RequestParam double x, @RequestParam double y, @RequestParam int level){
        switch (level){
            case 1:
                level = 100;
                break;
            case 2:
                level = 200;
                break;
            case 3:
                level = 400;
                break;
            case 4:
                level = 800;
                break;
            case 5:
                level = 1600;
                break;
        }

        return kakaoMapService.aroundStoreByXY(BigDecimal.valueOf(x), BigDecimal.valueOf(y), level);
    }
}
