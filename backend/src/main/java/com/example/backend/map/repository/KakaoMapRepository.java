package com.example.backend.map.repository;


import com.example.backend.map.entity.Store;

import java.util.Optional;

public interface KakaoMapRepository {
    Optional<Store> findById(String id);
    Store save(Store store);
}
