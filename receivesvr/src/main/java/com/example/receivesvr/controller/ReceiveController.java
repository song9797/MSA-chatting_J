package com.example.receivesvr.controller;

import com.example.receivesvr.DTO.ChatMessage;
import com.example.receivesvr.DTO.ResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/receive/v1")
public class ReceiveController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> receiveMessaeg(@RequestBody ChatMessage chatMessage){
        log.info("[" + chatMessage.getRoomId() + "] " + chatMessage.getSender() + ": " + chatMessage.getMessage());
        // try{
        //     log.info("[" + chatMessage.getRoomId() + "] " + chatMessage.getSender() + ": " + chatMessage.getMessage());
        // } catch (IOException e){
        //     e.printStackTrace();
        //     return ResponseEntity.internalServerError().body(new ResponseDTO(500, "message send fail"));
        // }
        return ResponseEntity.ok().body(new ResponseDTO(200, "testing"));
    }
    
}
