package com.example.hr_api_gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class HrApiGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGateway2Application.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
					.route(r -> r.path("/workers/**").uri("lb://hrworkers"))
					.route(r -> r.path("/payments/**").uri("lb://hrpayment"))
					.route(r -> r.path("/users/**").uri("lb://hrusers"))
					.route(r -> r.path("/oauth/**").uri("lb://hr-oauth")) 
				.build();
	}
}
