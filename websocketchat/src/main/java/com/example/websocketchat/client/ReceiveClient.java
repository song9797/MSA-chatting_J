package com.example.websocketchat.client;

import com.example.websocketchat.DTO.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveClient {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseDTO receiveMessage(WebSocketSession session, String message){
        ResponseEntity<ResponseDTO> restChange = restTemplate.exchange(
            "http://receiveservice/receive/v1/", 
            HttpMethod.POST, 
            null, 
            ResponseDTO.class);
            
        return restChange.getBody();
    }
}
    