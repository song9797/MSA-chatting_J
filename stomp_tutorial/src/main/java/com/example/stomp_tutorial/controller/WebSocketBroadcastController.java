package com.example.stomp_tutorial.controller;

import com.example.stomp_tutorial.DTO.Greeting;
import com.example.stomp_tutorial.DTO.HelloMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class WebSocketBroadcastController {
    private final SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}