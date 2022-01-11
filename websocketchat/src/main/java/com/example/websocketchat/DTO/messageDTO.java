package com.example.websocketchat.DTO;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class messageDTO {
    private WebSocketSession session;
    private String message;
}
