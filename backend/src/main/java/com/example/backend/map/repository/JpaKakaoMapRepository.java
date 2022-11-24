package com.example.backend.map.repository;

import com.example.backend.map.entity.Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
@Transactional
public class JpaKakaoMapRepository implements KakaoMapRepository  {

    private final EntityManager em;

    @Override
    public Optional<Store> findById(String id) {
        List<Store> result = em.createQuery("select s from store s where s.id = :id", Store.class)
                .setParameter("id", id)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Store save(Store store) {
        em.persist(store);
        return store;
    }
}
