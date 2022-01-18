package com.example.messagesubscriber.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.messagesubscriber.DTO.MessageDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
public class SubscriberService {
    Map<String, Set<WebSocketSession>> rooms = new HashMap<>();

    public void sendMessage(String roomId, MessageDTO messageDto){
        if(!rooms.containsKey(roomId)){
            rooms.put(roomId, new HashSet<>());
        }
        Set<WebSocketSession> sessions = rooms.get(roomId);
        sessions.parallelStream().forEach(session -> sendMessage(session, messageDto));
    }

    public void connectRoom(String roomId, WebSocketSession session){
        if(!rooms.containsKey(roomId)){
            rooms.put(roomId, new HashSet<>());
        }
        rooms.get(roomId).add(session);
    }
    public void disconnectRoom(String roomId, WebSocketSession session) {
        if(!rooms.containsKey(roomId)) return;
        rooms.get(roomId).remove(session);
    }
    
    private void sendMessage(WebSocketSession session, MessageDTO message){
        try {
            session.sendMessage(new TextMessage(message.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
