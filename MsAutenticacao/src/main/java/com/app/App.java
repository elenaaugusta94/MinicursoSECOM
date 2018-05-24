package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EntityScan("com.entities")
//@ComponentScan({"com.controller"})
//@EnableJpaRepositories("com.DAO")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAutoConfiguration
//@EnableFeignClients(basePackages = {"com.controller"})
@SpringBootApplication(scanBasePackages={"com.controller", "com.entities"})

public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class,args);
    }
}
