package com.dbcpool.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    DataSource dataSource(){
        /*
        * if we use DriverManagerDataSource then every time will create a new connection. So it's not good for production
        *
        * */
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(url);

        // C3P0 vendor that will provide DBCP class:- ComboPooledDataSource
//        ComboPooledDataSource dataSource= new ComboPooledDataSource(); // For use this class first we need to add c3p0 dependency in pom.xml

        // Hikari vendor that will provide DBCP
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);


        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
