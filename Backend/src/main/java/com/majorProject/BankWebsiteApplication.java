package com.majorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.majorProject")
public class BankWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankWebsiteApplication.class, args);
//		new SpringApplicationBuilder(BankWebsiteApplication.class)
//			.properties(singleton("server.port", 8081))
//			.registerShutdownHook(true)
//			.run(args);
	}

}
