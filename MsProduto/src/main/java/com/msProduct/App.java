package com.msProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@SpringBootApplication(scanBasePackages={"com.controller","com.entities"})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);

	}

}
