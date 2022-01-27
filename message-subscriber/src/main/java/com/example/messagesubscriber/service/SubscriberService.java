package com.example.messagesubscriber.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.messagesubscriber.DTO.MessageDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubscriberService {    
    Map<String, Map<String, WebSocketSession>> rooms = new HashMap<>();

    public void sendMessage(String roomId, MessageDTO messageDto){
        log.info("send: " + roomId + " message: " + messageDto.getMessage());
        if(!rooms.containsKey(roomId)){
            rooms.put(roomId, new HashMap<>());
        }
        Set<WebSocketSession> sessions = rooms.get(roomId).values().stream().collect(Collectors.toCollection(HashSet::new));
        sessions.parallelStream().forEach(session -> sendMessage(session, messageDto));
    }

    public void connectRoom(String roomId, WebSocketSession session, String userId){
        if(!rooms.containsKey(roomId)){
            rooms.put(roomId, new HashMap<>());
        }
        rooms.get(roomId).put(userId, session);
    }
    public void disconnectRoom(String roomId, String userId) {
        if(!rooms.containsKey(roomId)) return;
        rooms.get(roomId).remove(userId);
    }
    
    private void sendMessage(WebSocketSession session, MessageDTO message){
        try {
            session.sendMessage(new TextMessage(message.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
