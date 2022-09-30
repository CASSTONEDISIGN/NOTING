package com.example.noting_backend.user.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "User")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="pw")
    private String pw;
    @Column(name="create_at")
    private LocalDateTime createAt;
    @Column(name="update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
