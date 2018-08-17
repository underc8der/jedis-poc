package com.disney.poc.profile.jedispoc;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.disney.poc.profile.jedispoc.controller.RestCacheImpl;
import com.disney.poc.profile.jedispoc.controller.RestCacheService;

@SpringBootApplication
@ComponentScan
public class JedisPocApplication extends ResourceConfig{

	public JedisPocApplication() {
		packages("com.disney.poc.profile.jedispoc.controller");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JedisPocApplication.class, args);
	}
}
