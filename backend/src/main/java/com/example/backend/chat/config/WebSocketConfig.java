package com.example.backend.chat.config;

import com.example.backend.chat.handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

    private final ChatHandler ch;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(ch,"/ws/chat")
                .setAllowedOrigins("*")     // To do : 보안상의 문제로 전체 허용이 아닌 추후 직접 하나씩 지정
                .withSockJS();              // WebSocket 지원하지 못하는 경우를 위한 SockJS 사용 
    }
}
