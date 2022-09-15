package com.example.noting_backend.user.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "user")
@Getter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String pw;
}
