package com.bank.app.java_bank_pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.app.java_bank_pp.entity.User;

@SpringBootApplication
public class JavaBankPpApplication {

	public static void main(String[] args) {

		User u1 = new User();
		u1.builder().firstName("John").lastName("Doe").otherName("Smith").gender("Male").address("123 Main St").stateOfOrigin("New York").build();
		SpringApplication.run(JavaBankPpApplication.class, args);
	}

}