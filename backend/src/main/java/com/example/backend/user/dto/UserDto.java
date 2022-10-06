package com.example.backend.user.dto;

import com.example.backend.user.entity.User;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String email;
    private String pw;
    @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();



    public User toEntity() {
        return User.builder()
                .email(email)
                .pw(pw)
                .createAt(createAt)
                .build();
    }
}
