package com.riwi.clanes_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Para que el servicio se registre en el servidor Eureka
public class ClanesCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClanesCrudApplication.class, args);
	}

}
