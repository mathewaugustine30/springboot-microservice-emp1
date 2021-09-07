package com.java.mathew.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean  
	//creating a sampler called always sampler  
	public Sampler defaultSampler()  
	{  
	return Sampler.ALWAYS_SAMPLE;  
	}  

}
