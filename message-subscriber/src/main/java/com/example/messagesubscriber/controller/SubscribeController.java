package com.example.messagesubscriber.controller;

import com.example.messagesubscriber.DTO.MessageDTO;
import com.example.messagesubscriber.DTO.ResponseDTO;
import com.example.messagesubscriber.service.SubscriberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/sub")
public class SubscribeController {
    @Autowired
    private SubscriberService subscriberService;

    @RequestMapping(value = "/{roomId}/", method = RequestMethod.POST)
    public ResponseEntity<?> subscribeMessage(@PathVariable String roomId, @RequestBody MessageDTO messageDto){
        subscriberService.sendMessage(roomId, messageDto);
        return ResponseEntity.ok().body(new ResponseDTO(200, "message is successfully sended"));
    }
}
