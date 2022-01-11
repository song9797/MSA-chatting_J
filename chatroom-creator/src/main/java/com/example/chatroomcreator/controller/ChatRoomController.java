package com.example.chatroomcreator.controller;

import java.util.List;

import com.example.chatroomcreator.model.ChatRoom;
import com.example.chatroomcreator.service.ChatRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room/create")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ChatRoom createChatRoom(@RequestBody String name){
        return chatRoomService.createChatRoom(name);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ChatRoom> findAllRooms(){
        return chatRoomService.findAllRooms();
    }
}
