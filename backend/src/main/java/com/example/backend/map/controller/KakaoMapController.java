package com.example.backend.map.controller;

import com.example.backend.map.dto.KakaoMapProperty;
import com.example.backend.map.service.KakaoMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class KakaoMapController {

    private final KakaoMapService kakaoMapService;
    private final KakaoMapProperty property = new KakaoMapProperty();

//    옵션 1. 속성 변경과 api 요청을 분리
//    @GetMapping("/x-y-radius")
//    public void getXYRadius(@RequestParam(required = false) String x, @RequestParam(required = false) String y, @RequestParam(required = false) Integer radius){
//
//        if(x != null) kakaoMapDto.setX(x);
//        if(y != null) kakaoMapDto.setY(y);
//        if(radius != null) kakaoMapDto.setRadius(radius);
//
//        log.info(String.format("x = %s y= %s radius= %d", x, y, radius));
//    }
//
//    @GetMapping("/storeInfo")
//    public Map StoreInfo() {
//        return  kakaoMapService.getStoreInfo(kakaoMapDto);
//    }

//  옵션 2. 속성 변경과 api 요청을 통합
    @GetMapping("/store-info")
    public Map StoreInfo(@RequestParam(required = false) String x, @RequestParam(required = false) String y, @RequestParam(required = false) int radius) {

        if(x != null) property.setX(x);
        if(y != null) property.setY(y);
        if((Object) radius != null) property.setRadius(radius);

        log.info(String.format("x = %s y= %s radius= %d", x, y, radius));

        return  kakaoMapService.getStoreInfo(property);
    }
}
