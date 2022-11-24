package com.example.backend.map.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "store")
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
    private String distance;
    private String addressName;
    private String roadAddressName;
    private String phone;
    private String x;   // 경도
    private String y;   // 위도
}

