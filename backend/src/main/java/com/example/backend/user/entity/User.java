package com.example.backend.user.entity;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
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
