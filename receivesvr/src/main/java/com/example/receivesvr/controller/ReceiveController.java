package com.example.receivesvr.controller;

import java.io.IOException;

import com.example.receivesvr.DTO.ResponseDTO;
import com.example.receivesvr.DTO.messageDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/receive/v1 ")
public class ReceiveController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> receiveMessaeg(@RequestBody messageDTO messageDTO){
        try{
            WebSocketSession session = messageDTO.getSession();
            String message = messageDTO.getMessage();

            session.sendMessage(new TextMessage(message));
        } catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ResponseDTO(500, "message send fail"));
        }
        return ResponseEntity.ok().body(new ResponseDTO(200, "testing"));
    }
    
}
