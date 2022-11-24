package com.example.backend.map.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "store")
@Getter
@Setter
@ToString
@Component
public class Store {

    @Id
    String id;
    String placeName;
    String distance;
    String addressName;
    String roadAddressName;
    String phone;
    String x;   // 위도
    String y;   // 경도
}
