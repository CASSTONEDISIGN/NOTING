package com.example.noting_backend;

import com.example.noting_backend.user.hash.UserHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.noting_backend.user.repository.UserRepository;
import com.example.noting_backend.user.repository.JpaUserRepository;
import com.example.noting_backend.user.service.UserService;
import com.example.noting_backend.user.service.UserServiceImpl;

import javax.persistence.EntityManager;

@Configuration
public class Config implements WebMvcConfigurer {

    private final EntityManager em;

    @Autowired
    public Config(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository(), new UserHash());
    }

    @Bean
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }

}
