package com.example.noting_backend.user.dto;

import com.example.noting_backend.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String email;
    private String pw;
    private LocalDateTime createAt = LocalDateTime.now();


    public User toEntity() {
        return User.builder()
                .email(email)
                .pw(pw)
                .createAt(createAt)
                .build();
    }
}
