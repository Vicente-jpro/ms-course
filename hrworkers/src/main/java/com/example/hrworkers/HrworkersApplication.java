package com.example.hrworkers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/* Colocamos aqui o @RefreshScope porque estamos acessar as configuracoes
apartir de @Value("${test.config}")
*/
@RefreshScope 
@EnableEurekaClient
@SpringBootApplication
public class HrworkersApplication {

	@Value("${test.config}")
	private String profileType;
	
	@Bean
	public CommandLineRunner create() {
		return args ->{
			log.info("############## PROFILE TYPE: {} ##############",profileType);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HrworkersApplication.class, args);
	

	}

}
