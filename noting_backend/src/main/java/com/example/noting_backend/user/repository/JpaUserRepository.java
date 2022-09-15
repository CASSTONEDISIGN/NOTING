package com.example.noting_backend.user.repository;

import com.example.noting_backend.user.entity.UserEntity;

import javax.persistence.EntityManager;

//@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository{

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        em.persist(userEntity);
        return userEntity;
    }

//    @Override
//    public Optional<UserEntity> FindForLogin(String id, String pw) {
//        return Optional.empty();
//    }
}
