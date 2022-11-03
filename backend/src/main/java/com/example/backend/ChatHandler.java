package com.example.backend;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import java.util.ArrayList;

@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler {
    private static ArrayList<WebSocketSession> list = new ArrayList<>();

    @OnMessage
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws  Exception
    {
        String payload = message.getPayload();

        log.info("payload : " + payload);

        for(WebSocketSession sess : list){
            sess.sendMessage(message);
        }
    }

    /**
     * Client가 접속 시 호출되는 메서드
     */
    @OnOpen
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        list.add(session);

        JSONObject obj = new JSONObject();
        obj.put("type", "getId");
        obj.put("sessionId", session.getId());
        session.sendMessage(new TextMessage(obj.toString()));
        log.info(session + "클라이언트 접속");
    }
    /**
     * Client가 접속 해제 시 호출되는 메서드
     */
    @OnClose
    public void afterConnectionClosed(WebSocketSession session) throws Exception{
        log.info(session + "클라이언트 접속 해제");
        list.remove(session);
    }
}
