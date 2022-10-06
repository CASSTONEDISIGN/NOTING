package com.example.backend.user.entity;

import lombok.*;
<<<<<<< Updated upstream:backend/src/main/java/com/example/noting_backend/user/entity/User.java
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
=======
>>>>>>> Stashed changes:backend/src/main/java/com/example/backend/user/entity/User.java

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
