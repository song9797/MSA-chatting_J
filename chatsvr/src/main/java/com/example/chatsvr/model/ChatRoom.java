package com.example.chatsvr.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoom implements Serializable {
    private static final long serialVersionUID = 1293484892939L;
    private String roomId;
    private String name;

    public ChatRoom(String name){
        this.roomId = UUID.randomUUID().toString();
        this.name = name;
    }
}
