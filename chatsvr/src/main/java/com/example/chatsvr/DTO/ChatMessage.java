package com.example.chatsvr.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage implements Serializable {
    private static final long serialVersionUID = 1293484892939L;
    private String roomId;
    private String sneder;
}
