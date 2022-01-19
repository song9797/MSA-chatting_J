package com.example.chatroomreader.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatRoom {
    @Id
    private String id;
    private String name;
}