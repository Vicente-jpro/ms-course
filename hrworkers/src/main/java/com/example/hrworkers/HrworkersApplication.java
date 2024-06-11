package com.example.hrworkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrworkersApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrworkersApplication.class, args);
	}

}
