package com.example.stomp_tutorial.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {
    private String from;
    private String text;
    private String recipient;
    private String time;

    public ChatMessage(String from, String text, String recipient){
        this.from = from;
        this.text = text;
        this.recipient = recipient;
        Date now = new Date();
        this.time = now.toString();
    }
}