package com.example.backend.user.repository;

<<<<<<< Updated upstream:backend/src/main/java/com/example/noting_backend/user/repository/JpaUserRepository.java
import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;
=======
import com.example.backend.user.entity.User;
>>>>>>> Stashed changes:backend/src/main/java/com/example/backend/user/repository/JpaUserRepository.java
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findUser(User user) {
        List<User> result = em.createQuery("select m from User m where m.email = :email and m.pw = :pw", User.class)
                .setParameter("email", user.getEmail())
                .setParameter("pw", user.getPw())
                .getResultList();
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return result.stream().findAny();
    }
    /**
     * 비밀번호 변경을 위한 함수
     */
    @Override
    public Optional<User> changePw(User user, String newpw) {
        // 전 비밀번호를 로그인 유저 찾기
        Optional<User> result = findUser(user);
        // 아이디 받아오기
        Long user_id = result.get().getId();

        em.createQuery("update User m set m.pw = :pw where m.id = :id")
                .setParameter("pw", newpw)
                .setParameter("id", user_id)
                .executeUpdate();

        List<User> result2 = em.createQuery("select m from User m where m.email = :email and m.pw = :pw", User.class)
                .setParameter("email", user.getEmail())
                .setParameter("pw", newpw)
                .getResultList();

        return  result2.stream().findAny();
    }
}
