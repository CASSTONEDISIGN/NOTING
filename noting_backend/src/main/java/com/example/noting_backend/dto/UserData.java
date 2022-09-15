package com.example.noting_backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "")
@Setter
@Getter
@ToString
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_num;

    @Column
    private String id;

    @Column
    private String pw;
}
