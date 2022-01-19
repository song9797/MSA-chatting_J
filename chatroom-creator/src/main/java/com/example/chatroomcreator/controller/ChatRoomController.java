package com.example.chatroomcreator.controller;

import com.example.chatroomcreator.DTO.ResponseDTO;
import com.example.chatroomcreator.model.ChatRoom;
import com.example.chatroomcreator.service.ChatRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createChatRoom(@RequestBody String name){
        ChatRoom chatRoom = chatRoomService.createChatRoom(name);
        return ResponseEntity.ok().body(new ResponseDTO(200, "chatroom created", chatRoom));
    }
}
