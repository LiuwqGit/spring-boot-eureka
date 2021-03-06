package com.yyit.marketOperation.message;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@ComponentScan(basePackages={"com.yyit.*"})
@SpringBootApplication
@EnableSwagger2
public class Application {

	@Bean
	  public Docket petApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	          .apis(RequestHandlerSelectors.any())
	          .paths(PathSelectors.any())
	          .build()
	        .pathMapping("/")
	        .directModelSubstitute(LocalDate.class,
	            String.class)
	        .genericModelSubstitutes(ResponseEntity.class)
	        
	        .useDefaultResponseMessages(false)
	       
	       
	        .enableUrlTemplating(true);
	    
	 
	  }
	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SpringApplication.run(Application.class, args);
	}

}
