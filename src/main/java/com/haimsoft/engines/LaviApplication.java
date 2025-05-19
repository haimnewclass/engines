package com.haimsoft.engines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// http://localhost:15672/#/
@SpringBootApplication
@ComponentScan(basePackages = {"com.haimsoft.engines", "com.example.rabbitmqproducer"})
public class LaviApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaviApplication.class, args);
	}

	
	
	

}
