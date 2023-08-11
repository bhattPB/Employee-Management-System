package com.pb.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementSystemApplication.class, args);


	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.pb.employeemanagementsystem.controller"))
				.build().apiInfo(metadata());
	}
	@Bean
	public ApiInfo metadata() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("My Application API through Swagger UI").version("1.0").license("(C) Copyright Test")
				.description("List of all the APIs of My Application App through Swagger UI");
		return builder.build();
	}

}
