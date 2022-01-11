package com.example.sendsvr.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.sendsvr.DTO.ChatMessage;
import com.example.sendsvr.client.ReceiveClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private Map<String, Set<WebSocketSession>> rooms = new HashMap<>();
    @Autowired
    private ReceiveClient receiveClient;

    public void handleAction(WebSocketSession session, ChatMessage message) throws Exception {
        if(rooms.containsKey(message.getRoomId())){
            rooms.get(message.getRoomId()).add(session);
        } else {
            rooms.put(message.getRoomId(), new HashSet<>());
            rooms.get(message.getRoomId()).add(session);
        }
        receiveClient.receiveMessage(message);
        redisTemplate.delete(message.getRoomId());
        rooms.get(message.getRoomId()).parallelStream().forEach(sess -> sendMessage(sess, message));
    }

    private void sendMessage(WebSocketSession session, ChatMessage message){
        try {
            session.sendMessage(new TextMessage(message.getMessage()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
