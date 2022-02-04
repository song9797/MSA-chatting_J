package com.example.messagesubscriber.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.messagesubscriber.DTO.MessageDTO;
import com.example.messagesubscriber.model.RoomUser;
import com.example.messagesubscriber.repository.RoomUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class SubscriberService {    
    Map<String, Map<String, WebSocketSession>> rooms = new HashMap<>();

    @Autowired
    private RoomUserRepository roomUserRepository;
    
    public void sendMessage(String roomId, MessageDTO messageDto){
        log.info("send: " + roomId + " message: " + messageDto.getMessage());
        List<RoomUser> users = roomUserRepository.findByRoomId(roomId);
        for(RoomUser user : users){
            log.info(user.getRoomId() + " " + user.getUserId());
        }
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

    private List<RoomUser> getUsers(String roomId){
        return roomUserRepository.findByRoomId(roomId);
    }
}
