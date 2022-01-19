package com.example.chatroomcreator.service;

import java.util.UUID;

import com.example.chatroomcreator.DTO.ChatRoomDTO;
import com.example.chatroomcreator.model.ChatRoom;
import com.example.chatroomcreator.repository.ChatRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository roomRepository;

    public ChatRoom createChatRoom(ChatRoomDTO chatRoomDTO) {
        String id = UUID.randomUUID().toString();
        ChatRoom chatRoom = roomRepository.save(new ChatRoom(id, chatRoomDTO.getName()));
        return chatRoom;
    }
}
