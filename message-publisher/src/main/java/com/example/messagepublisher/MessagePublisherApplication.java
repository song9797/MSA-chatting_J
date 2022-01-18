package com.example.messagepublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MessagePublisherApplication {
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplat(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MessagePublisherApplication.class, args);
	}

}
