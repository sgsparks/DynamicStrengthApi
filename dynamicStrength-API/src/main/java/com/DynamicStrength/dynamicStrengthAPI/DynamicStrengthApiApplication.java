package com.DynamicStrength.dynamicStrengthAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class DynamicStrengthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicStrengthApiApplication.class, args);
	}

}
