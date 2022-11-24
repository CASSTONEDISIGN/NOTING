package com.example.backend.map.repository;


import com.example.backend.map.entity.Store;

import java.util.Optional;

public interface KakaoMapRepository {
    Optional<Store> findByName(String place_name);
    Optional<Store> findBylikeName(String place_name);
    Store save(Store store);
}
