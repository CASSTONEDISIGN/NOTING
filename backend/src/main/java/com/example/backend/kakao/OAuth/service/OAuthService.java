package com.example.backend.kakao.OAuth.service;

import org.springframework.stereotype.Service;

@Service
public class OAuthService {

    public String getKakaoAccessToken(String code){
        String accessToken = "";
        String refreshToken = "";
        String requestURL = "https://kauth.kakao.com/oauth/token";

        return null;
    }
}
