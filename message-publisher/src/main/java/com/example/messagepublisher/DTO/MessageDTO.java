package com.example.messagepublisher.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String sender;
    private String message;

    @Override
    public String toString(){
        return this.sender + ": " + this.message;
    }
}
