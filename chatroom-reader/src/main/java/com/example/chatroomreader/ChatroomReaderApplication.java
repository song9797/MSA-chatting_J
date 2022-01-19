package com.example.chatroomreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ChatroomReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatroomReaderApplication.class, args);
	}

}
