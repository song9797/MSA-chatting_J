package com.example.receivesvr.DTO;

import org.springframework.web.socket.WebSocketSession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class messageDTO {
    WebSocketSession session;
    String message;
}
