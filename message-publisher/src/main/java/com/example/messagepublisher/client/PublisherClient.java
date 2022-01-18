package com.example.messagepublisher.client;

import com.example.messagepublisher.DTO.MessageDTO;
import com.example.messagepublisher.DTO.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PublisherClient {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseDTO publishMessage(MessageDTO messageDto, String roomId){
        log.info(messageDto.getSender() + ": " + messageDto.getMessage());
        ResponseEntity<ResponseDTO> restChange = restTemplate.exchange(
            "http://messagesubscriber/sub/{roomId}/",
            HttpMethod.POST,
            new HttpEntity<>(messageDto),
            ResponseDTO.class,
            roomId);
        return restChange.getBody();
    }
}
