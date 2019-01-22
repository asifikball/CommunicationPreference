package com.cointribe.communication.preferences.preferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.cointribe.communication.preferences")
@EntityScan("com.cointribe.communication.preferences")
@EnableJpaRepositories("com.cointribe.communication.preferences")
public class PreferencesApplication{

	public static void main(String[] args) {
		SpringApplication.run(PreferencesApplication.class, args);
	}

	

}

