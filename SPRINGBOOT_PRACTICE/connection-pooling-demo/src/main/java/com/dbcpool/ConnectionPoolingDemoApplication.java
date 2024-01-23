package com.dbcpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class ConnectionPoolingDemoApplication implements CommandLineRunner {

	/*
	* Spring boot by default use Hikari vendor for DBCP (database connection pooling) because Hikari is very good mechanism to DBCP.
	* some other vendors also available in market like: oracle,apache and C3P0 e.t.c that provide DBCP
	* */

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConnectionPoolingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("app started.....");

		List<Map<String, Object>> mapList = this.jdbcTemplate.queryForList("select * from persons");
		mapList.forEach(item ->{
			System.out.println("Id: "+item.get("id"));
			System.out.println("Name: "+item.get("name"));
			System.out.println("City: "+item.get("city"));
			System.out.println("\n*****************************\n");
		});
	}
}
