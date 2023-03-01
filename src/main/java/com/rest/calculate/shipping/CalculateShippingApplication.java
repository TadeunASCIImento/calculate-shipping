package com.rest.calculate.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CalculateShippingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CalculateShippingApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CalculateShippingApplication.class);
	}

}
