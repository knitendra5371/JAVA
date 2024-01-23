package com.jwtwithdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JwtWithDbDemoApplication {

//	JdbcClient introduce in spring 6.1 version. if we use spring boot 3.2.0 then it's use spring 6.1 version
	public static void main(String[] args) {
		SpringApplication.run(JwtWithDbDemoApplication.class, args);
	}

}
