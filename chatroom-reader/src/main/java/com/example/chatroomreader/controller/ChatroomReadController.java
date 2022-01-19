package com.example.chatroomreader.controller;

import java.util.List;

import com.example.chatroomreader.DTO.ResponseDTO;
import com.example.chatroomreader.model.ChatRoom;
import com.example.chatroomreader.service.ChatroomReadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/room/read")
public class ChatroomReadController {
    @Autowired
    private ChatroomReadService roomService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> findAllRooms(){
        List<ChatRoom> rooms = roomService.findAll();
        return ResponseEntity.ok().body(new ResponseDTO(200, "all rooms", rooms));
    }
}
