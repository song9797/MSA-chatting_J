package com.example.chatsvr.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.chatsvr.model.ChatRoom;
import com.example.chatsvr.service.RedisSubscriber;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ChatRoomRepository {
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private final RedisMessageListenerContainer listener;
    private final RedisSubscriber redisSubscriber;
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, ChatRoom> hashRoomOps;
    private Map<String, ChannelTopic> topics;
    
    @PostConstruct
    private void init(){
        hashRoomOps = redisTemplate.opsForHash();
        topics = new HashMap<>();
    }
    
    public List<ChatRoom> findAllRooms(){
        return hashRoomOps.values(CHAT_ROOMS);
    }

    public ChatRoom findById(String id){
        return hashRoomOps.get(CHAT_ROOMS, id);
    }

    public ChatRoom createChatRoom(String name){
        ChatRoom chatRoom = new ChatRoom(name);
        hashRoomOps.put(CHAT_ROOMS, chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    public void enterChatRoom(String roomId){
        ChannelTopic topic = topics.get(roomId);
        if(topic == null){
            topic = new ChannelTopic(roomId);
            listener.addMessageListener(redisSubscriber, topic);
            topics.put(roomId, topic);
        }
    }

    public ChannelTopic getTopic(String roomId){
        return topics.get(roomId);
    }
}
