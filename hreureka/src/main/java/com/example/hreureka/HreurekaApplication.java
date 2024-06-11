package com.example.hreureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HreurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HreurekaApplication.class, args);
	}

}
