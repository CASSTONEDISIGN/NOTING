package com.example.noting_backend.user.repository;

import com.example.noting_backend.user.entity.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
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
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findUser(User userEntity) {
        List<User> result = em.createQuery("select m from User m where m.email = :email and m.pw = :pw", User.class)
                .setParameter("email", userEntity.getEmail())
                .setParameter("pw", userEntity.getPw())
                .getResultList();
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return result.stream().findAny();
    }
}
