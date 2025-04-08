package com.example.spring_boot_mini_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBootMiniProjectApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringBootMiniProjectApplication.class, args);

//		Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
		System.out.println("Connected to the database!");
	}



}
