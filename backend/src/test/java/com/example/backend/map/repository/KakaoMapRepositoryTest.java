package com.example.backend.map.repository;

import com.example.backend.map.entity.Store;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@ToString
class KakaoMapRepositoryTest {

    @Autowired
    KakaoMapRepository kakaoMapRepository;

    @Test
    void selectByDistance() {
        List<Store> store = kakaoMapRepository.selectByDistance(BigDecimal.valueOf(127.87179754134), BigDecimal.valueOf(36.967257621809), 300);

        for(int i=0; i< store.size(); i++){
            log.info(store.get(i).toString());
        }

    }
}