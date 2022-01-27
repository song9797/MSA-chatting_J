package com.example.messagesubscriber.handler;

import java.util.ArrayList;
import java.util.List;

import com.example.messagesubscriber.DTO.MessageDTO;
import com.example.messagesubscriber.service.SubscriberService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private SubscriberService subscriberService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("session: " + session.toString() + " payload: " + payload);
        MessageDTO messageDto = objectMapper.readValue(payload, MessageDTO.class);
        for(WebSocketSession sess : sessions){
            sess.sendMessage(new TextMessage(messageDto.toString()));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        String cookie = session.getHandshakeHeaders().get("cookie").get(0);
        log.info(cookie);
        
        String userId = cookie.split("; ")[0].split("=")[1];
        String roomId = cookie.split("; ")[1].split("=")[1];
        log.info("user: " + userId + " roomId: " + roomId); 
        subscriberService.connectRoom(roomId, session, userId);
        log.info(session + " 클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해지");
        String roomId = session.getHandshakeHeaders().get("cookie").toString().split("=")[1];
        roomId = roomId.substring(0, roomId.length()-1);
        // subscriberService.disconnectRoom(roomId, session);
        sessions.remove(session);
    }
}
