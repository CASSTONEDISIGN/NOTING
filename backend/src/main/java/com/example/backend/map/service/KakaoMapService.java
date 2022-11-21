package com.example.backend.map.service;

import com.example.backend.map.dto.KakaoMapProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class KakaoMapService {

    public Map getStoreInfo(KakaoMapProperty property){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + property.getKey()); //Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); //엔티티로 만들기

        URI targetUrl = UriComponentsBuilder
                .fromUriString(property.getUrl() + "/v2/local/search/category.json")
                .queryParam("category_group_code", property.getCATEGORY_GROUP_CODE())
                .queryParam("x", property.getX())
                .queryParam("y", property.getY())
                .queryParam("radius", property.getRadius())
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        ResponseEntity<Map> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, Map.class);

        return result.getBody(); //내용 반환
    }
}
