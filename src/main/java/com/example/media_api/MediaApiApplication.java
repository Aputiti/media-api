package com.example.media_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MediaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaApiApplication.class, args);
	}

}
