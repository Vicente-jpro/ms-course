package com.example.hrpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "hrworkers")
@EnableFeignClients
@SpringBootApplication
public class HrpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrpaymentApplication.class, args);
	}

}
