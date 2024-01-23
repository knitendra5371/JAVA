package com.swgr;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootWithSwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWithSwaggerDemoApplication.class, args);
	}


	/*
	* http://localhost:8080/swagger-ui/index.html
	* http://localhost:8080/v3/api-docs
	*http://localhost:8080/api-docs.yaml
	* */
}
