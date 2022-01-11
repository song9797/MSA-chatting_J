package com.example.chatroomcreator.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private Set<WebSocketSession> sessions;
}
