package com.employee.employeedirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages="com.employee.employeedirectory")
@EnableJpaRepositories("com.employee.employeedirectory.Repository")
public class EmployeeDirectoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDirectoryApplication.class, args);
    }

}