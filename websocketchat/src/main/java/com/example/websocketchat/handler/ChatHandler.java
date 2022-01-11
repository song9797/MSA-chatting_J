package com.example.websocketchat.handler;

import java.util.ArrayList;
import java.util.List;

import com.example.websocketchat.client.ReceiveClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> sessions = new ArrayList<>();
    
    @Autowired
    private ReceiveClient receiveClient;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("session: " + session.toString() + " payload: " + payload);

        receiveClient.receiveMessage(session,payload);
        // for(WebSocketSession sess : sessions){
        //     sess.sendMessage(message);
        // }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info(session + " 클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해지");
        sessions.remove(session);
    }
}
