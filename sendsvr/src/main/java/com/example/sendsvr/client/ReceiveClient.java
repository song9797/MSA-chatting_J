package com.example.sendsvr.client;

import com.example.sendsvr.DTO.ChatMessage;
import com.example.sendsvr.DTO.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveClient {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseDTO receiveMessage(ChatMessage chatMessage){
        log.info(chatMessage.getSender() + ": " + chatMessage.getMessage());
        ResponseEntity<ResponseDTO> restChange = restTemplate.exchange(
            "http://receiveservice/receive/v1/", 
            HttpMethod.POST, 
            new HttpEntity<>(chatMessage),
            ResponseDTO.class);
        return restChange.getBody();
    }
}
