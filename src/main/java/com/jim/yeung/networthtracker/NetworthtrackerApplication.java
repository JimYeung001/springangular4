package com.jim.yeung.networthtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NetworthtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworthtrackerApplication.class, args);
	}
}
