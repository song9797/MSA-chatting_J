package com.example.messagepublisher.controller;

import com.example.messagepublisher.DTO.MessageDTO;
import com.example.messagepublisher.DTO.ResponseDTO;
import com.example.messagepublisher.client.PublisherClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/pub")
public class PublisheController {
    @Autowired
    private PublisherClient publisherClient;

    @RequestMapping(value = "/{roomId}/", method = RequestMethod.POST)
    public ResponseEntity<?> publishMessage(@PathVariable String roomId, @RequestBody MessageDTO messageDto){
        publisherClient.publishMessage(messageDto, roomId);
        return ResponseEntity.ok().body(new ResponseDTO(200, "message sended"));
    }
}
