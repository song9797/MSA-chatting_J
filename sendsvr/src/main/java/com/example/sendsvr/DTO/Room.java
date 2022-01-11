package com.example.sendsvr.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room implements Serializable {
    private static final long serialVersionUID = 2193485849932L;
    private Set<WebSocketSession> sessions;

    public Room(){
        sessions = new HashSet<>();
    }
}
