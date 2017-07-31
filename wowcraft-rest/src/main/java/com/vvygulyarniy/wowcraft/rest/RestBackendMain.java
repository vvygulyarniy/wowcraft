package com.vvygulyarniy.wowcraft.rest;

import com.vvygulyarniy.wowcraft.rest.config.MainSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MainSpringConfig.class)
public class RestBackendMain {

	public static void main(String[] args) {
		SpringApplication.run(RestBackendMain.class, args);
	}
}
