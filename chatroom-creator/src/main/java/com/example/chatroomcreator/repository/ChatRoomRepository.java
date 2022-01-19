package com.example.chatroomcreator.repository;

import com.example.chatroomcreator.model.ChatRoom;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom,String> {
    
}
