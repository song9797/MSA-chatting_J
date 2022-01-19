package com.example.chatroomreader.repsitory;

import java.util.List;

import com.example.chatroomreader.model.ChatRoom;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {
    List<ChatRoom> findAll();   
}
