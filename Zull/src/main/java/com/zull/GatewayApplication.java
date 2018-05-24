package com.zull;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {

	static Logger logger = Logger.getLogger(GatewayApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
		logger.info("Microserviço ZUUl iniciado com sucesso!");
	}
}
