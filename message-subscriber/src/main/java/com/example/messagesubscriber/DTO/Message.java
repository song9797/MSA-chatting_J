package com.example.messagesubscriber.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {
    private String sender;
    private String message;

    @Override
    public String toString(){
        return this.sender + ": " + this.message;
    }
}
