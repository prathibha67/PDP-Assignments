package com.example.Dependency;

import Controller.MyController;
import SFactory.ServiceFactory;
import SFactory.ServiceFactoryImpl;
import Service.AuthenticationService;
import Service.DatabaseService;
import Service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application  {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
