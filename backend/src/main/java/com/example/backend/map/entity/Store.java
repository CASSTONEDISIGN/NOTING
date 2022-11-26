package com.example.backend.map.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Store")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "place_name")
    private String placeName;
    private String addressName;
    private String roadAddressName;
    private String phone;
    private BigDecimal x;   // 경도 longitude
    private BigDecimal y;   // 위도 latitude

}

