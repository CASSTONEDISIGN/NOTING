package com.example.backend.service;

import com.example.backend.map.service.KakaoMapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class StoreServiceTest {
    @Autowired
    KakaoMapService service;
    @Autowired
//    JpaKakaoMapRepository repository;
    @Test
    public void 가게이름_검색() throws Exception {
//        Optional<Store> result = repository.findByName("두");

//        System.out.println("result.get().toString() = " + result.get().toString());
    }
}
