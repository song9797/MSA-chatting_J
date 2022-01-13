package com.example.messagesubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MessageSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageSubscriberApplication.class, args);
	}

}
