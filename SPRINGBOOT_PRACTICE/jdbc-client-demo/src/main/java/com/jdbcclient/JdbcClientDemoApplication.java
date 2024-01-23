package com.jdbcclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcClientDemoApplication {
/*

	The new JdbcClient Introduced in Spring Framework 6.1

	You'll see this when we glance over the code. One exciting feature with the JDBC client is that it's auto-configured for us in Spring Boot 3.2. This means we can simply ask for a bean in our application, and we get an instance of it
*/

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientDemoApplication.class, args);
	}

}
