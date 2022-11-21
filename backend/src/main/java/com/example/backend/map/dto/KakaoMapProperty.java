package com.example.backend.map.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KakaoMapProperty {

    @Value("${REST_KEY}")
    private String key;                                      // 카카오 REST_KEY
    @Setter
    private String x = "127.87179754134";                    // 경도
    @Setter
    private String y = "36.967257621809";                    // 위도
    @Setter
    private Integer radius = 3000;                           // 반경
    private String url = "https://dapi.kakao.com";           // 기본 url
    private final String CATEGORY_GROUP_CODE = "FD6";        // 음식점
}
