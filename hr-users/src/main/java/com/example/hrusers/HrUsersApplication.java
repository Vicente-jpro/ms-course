package com.example.hrusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableEurekaClient
@SpringBootApplication
//@EnableFeignClients(basePackages = "com.example.hrusers.clients")
public class HrUsersApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(HrUsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//	 log.info("PASSWORD: 123456 CRYPTED: {}",  passwordEncoder.encode("12345678"));
	}

}
