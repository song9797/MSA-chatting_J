package com.example.websocketchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chatGet(){
        log.info("Get chat.html");
        return "chat";
    }
}
