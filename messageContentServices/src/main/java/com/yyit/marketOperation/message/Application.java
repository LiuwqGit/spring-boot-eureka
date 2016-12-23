package com.yyit.marketOperation.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@EnableDiscoveryClient
@ComponentScan(basePackages={"com.yyit.*"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SpringApplication.run(Application.class, args);
	}

}
