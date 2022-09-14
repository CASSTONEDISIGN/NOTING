package com.example.noting_backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "")
@Setter
@Getter
@ToString
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_num;

    @Column
    private String Id;

    @Column
    private String Pw;
}
