package com.example.chatroomreader.service;

import java.util.List;

import com.example.chatroomreader.model.ChatRoom;
import com.example.chatroomreader.repsitory.ChatRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ChatroomReadService {
    @Autowired
    private ChatRoomRepository roomRepository;

    public List<ChatRoom> findAll(){
        return roomRepository.findAll();
    }          
}
