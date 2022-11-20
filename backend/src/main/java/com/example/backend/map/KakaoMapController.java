package com.example.backend.map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController("/kakao")
public class KakaoMapController {

    @Value("${REST_KEY}")
    private String key;     // 카카오 REST_KEY
    private final String url = "https://dapi.kakao.com/v2/local/search/category.json";  // 기본 url
    private final String CATEGORY_GROUP_CODE = "FD6";            // FD6 : 음식점
    private String y = "36.967257621809";   // 위도
    private String x = "127.87179754134";   // 경도
    private Integer radius = 3000;  // 반경

    @GetMapping("/storeInfo")
    public Map StoreInfo() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + key); //Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); //엔티티로 만들기
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("category_group_code", CATEGORY_GROUP_CODE)
                .queryParam("x", x)
                .queryParam("y", y)
                .queryParam("radius", radius)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        //GetForObject는 헤더를 정의할 수 없음
        ResponseEntity<Map> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, Map.class);
        return result.getBody(); //내용 반환
    }
}
