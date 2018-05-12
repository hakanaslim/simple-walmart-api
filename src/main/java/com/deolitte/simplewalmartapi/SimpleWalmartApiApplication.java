package com.deolitte.simplewalmartapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SimpleWalmartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWalmartApiApplication.class, args);
	}
}
