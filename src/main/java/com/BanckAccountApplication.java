package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "java.com")
//@EnableJpaRepositories("java.com.repository")
@EntityScan(basePackages = "com.entity")
public class BanckAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanckAccountApplication.class, args);
	}

}
