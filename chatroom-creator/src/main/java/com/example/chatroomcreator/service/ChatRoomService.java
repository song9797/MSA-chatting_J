package com.example.chatroomcreator.service;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.example.chatroomcreator.model.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class ChatRoomService {
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    private void init() {
        chatRooms = new HashMap<>();
    }

    public List<ChatRoom> findAllRooms(){
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom createChatRoom(String name){
        String id = UUID.randomUUID().toString();
        ChatRoom chatRoom = new ChatRoom(id, name, null);
        chatRooms.put(id, chatRoom);
        redisTemplate.opsForSet().add(id, new HashSet<WebSocket>());
        return chatRoom;
    }
}
