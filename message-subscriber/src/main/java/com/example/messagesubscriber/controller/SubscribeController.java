package com.example.messagesubscriber.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.example.messagesubscriber.DTO.Message;
import com.example.messagesubscriber.DTO.ResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/sub")
public class SubscribeController {
    Map<String, Set<WebSocketSession>> rooms = new HashMap<>();
    
    @RequestMapping(value = "/{roomId}/", method = RequestMethod.POST)
    public ResponseEntity<?> subscribeMessage(@PathVariable String roomId, @RequestBody Message message){
        if(!rooms.containsKey(roomId)){
            return ResponseEntity.badRequest().body(new ResponseDTO(400, "wrong room id"));
        }
        Set<WebSocketSession> sessions = rooms.get(roomId);
        sessions.parallelStream().forEach(session -> sendMessage(session, message));
        return ResponseEntity.ok().body(new ResponseDTO(200, "message is successfully sended"));
    }

    private void sendMessage(WebSocketSession session, Message message){
        try {
            session.sendMessage(new TextMessage(message.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
