package com.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//
//@EntityScan("com.entities")
//@ComponentScan({ "com.controller" })
//@EnableJpaRepositories("com.DAO")

@EnableEurekaClient
@EnableDiscoveryClient
@EnableAutoConfiguration
//@EnableFeignClients(basePackages = { "com.intercomm", "com.controller" })
@SpringBootApplication(scanBasePackages = { "com.entities", "com.controller" })
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
