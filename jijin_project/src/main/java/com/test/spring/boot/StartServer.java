package com.test.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class StartServer {

	public static void main(String[] args) {
		SpringApplication.run(StartServer.class, args);
	}
	
	
	@Configuration
	class DevConfig extends WebMvcConfigurerAdapter {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("*");
		}
	}
}
