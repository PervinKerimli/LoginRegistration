package com.SpringSecurity.LoginRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class LoginRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistrationApplication.class, args);
	}

}
