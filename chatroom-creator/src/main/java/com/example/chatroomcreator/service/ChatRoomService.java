package com.example.chatroomcreator.service;

import com.example.chatroomcreator.model.ChatRoom;
import com.example.chatroomcreator.repository.ChatRoomRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service 
@Transactional
@RequiredArgsConstructor
public class ChatRoomService {
    private ChatRoomRepository roomRepository;

    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = roomRepository.save(new ChatRoom(name));
        return chatRoom;
    }
}
