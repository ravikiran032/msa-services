package com.salesorder.service.salesorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.salesorder.service.salesorderservice")
public class SalesorderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesorderServiceApplication.class, args);
	}

}
