package com.example.backend.map.service;

import com.example.backend.map.entity.Store;
import com.example.backend.map.repository.KakaoMapRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
@RequiredArgsConstructor
@ToString
public class KakaoMapService {

    @Value("${REST_KEY}")
    private String key;                                      // 카카오 REST_KEY
    private final int radius = 3000;                         // 반경
    private final String url = "https://dapi.kakao.com";     // 기본 url
    private final String CATEGORY_GROUP_CODE = "FD6";        // 음식점
    private final KakaoMapRepository kakaoMapRepository;
    private final Store store;

    public void getStoreByCategory(String x, String y){
        URI targetUrl;                  // 요청 url
        ResponseEntity<Map> result;     // 응답 정보
        JSONObject jsonObj;             // 응답 정보를 json으로 변환
        JSONArray documents;            // 가게 정보를 json 배열로 변환
        int maxPage = 1;                // 최대 가져올 수 있는 페이지 수

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.set("Authorization", "KakaoAK " + key);                 // Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);      // 엔티티로 만들기

        int page = 1;
        while(page <= maxPage){
            // url 생성
            targetUrl = UriComponentsBuilder
                    .fromUriString(url + "/v2/local/search/category.json")
                    .queryParam("category_group_code", CATEGORY_GROUP_CODE)
                    .queryParam("x", x)
                    .queryParam("y", y)
                    .queryParam("radius", radius)
                    .queryParam("page", page)
                    .build()
                    .encode(StandardCharsets.UTF_8)
                    .toUri();

            // 요청
            result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, Map.class);

            // 받은 객체를 json으로 변환
            jsonObj = new JSONObject(result.getBody());
            // 메타 정보에서 최대 페이지 수를 할당
            maxPage = jsonObj.getJSONObject("meta").getInt("pageable_count");
            // 가게 정보(Array)를 jsonArray로 할당
            documents = jsonObj.getJSONArray("documents");

            // insert
            for(int i = 0; i < documents.length() ; i++){
                JSONObject obj = documents.getJSONObject(i);

                // db 내에 이미 정보가 있으면 스킵
                if(kakaoMapRepository.findById(obj.getString("id")).isPresent())
                    continue;

                store.setId(obj.getString("id"));
                store.setPlaceName(obj.getString("place_name"));
                store.setDistance(obj.getString("distance"));
                store.setAddressName(obj.getString("address_name"));
                store.setRoadAddressName(obj.getString("road_address_name"));
                store.setPhone(obj.getString("phone"));
                store.setX(obj.getString("x"));
                store.setY(obj.getString("y"));

                kakaoMapRepository.save(store);
            }
            page++;
        }

        log.info("insert success");
    }
}
