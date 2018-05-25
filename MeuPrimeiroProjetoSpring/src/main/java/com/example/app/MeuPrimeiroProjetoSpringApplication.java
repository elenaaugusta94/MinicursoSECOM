package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class MeuPrimeiroProjetoSpringApplication {
	@Value("${value:SECOM: O melhor evento de computação de minas! }")
	String valor;
	@RequestMapping(value="mensagem")
	public String getMensagem()	{
		return valor;
	}
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoSpringApplication.class, args);
	}
}
