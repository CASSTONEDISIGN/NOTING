package com.example.backend.map.repository;


import com.example.backend.map.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface KakaoMapRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByPlaceName(String placeName);
    Optional<Store> findByPlaceNameLike(String placeName);
    @Query(value = "SELECT\n" +
            "    *,\n" +
            "    ((6371 * acos( cos( radians(:y) ) * cos( radians( `y` ) ) * cos( radians( `x` ) - radians(:x) ) + sin( radians(:y) ) * sin(radians( `y` ))))) * 1000  AS distance\n" +
            "FROM `store`\n" +
            "HAVING distance <= :radius\n" +
            "ORDER BY distance ASC;", nativeQuery = true)
    List<Store> selectByDistance(@Param(value ="x") BigDecimal x, @Param(value = "y") BigDecimal y, @Param(value = "radius") int radius);
}
