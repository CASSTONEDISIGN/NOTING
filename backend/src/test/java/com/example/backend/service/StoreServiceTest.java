package com.example.backend.service;

import com.example.backend.map.entity.Store;
import com.example.backend.map.repository.JpaKakaoMapRepository;
import com.example.backend.map.repository.KakaoMapRepository;
import com.example.backend.map.service.KakaoMapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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
