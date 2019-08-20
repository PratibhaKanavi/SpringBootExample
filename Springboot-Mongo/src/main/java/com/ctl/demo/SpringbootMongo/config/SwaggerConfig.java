package com.ctl.demo.SpringbootMongo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	@Bean
	public Docket pDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.ctl.demo.SpringbootMongo"))
		.paths(regex("/rest.*"))
		.build().apiInfo(metaInfo());
	}
	

	private ApiInfo metaInfo() {
		// TODO Auto-generated method stub
		
		return new ApiInfoBuilder().title("SpringBoot-Swagger-MongoDB").description("SpringBoot-Swagger Example-MongoDB")
				.version("1.0.0")
				.build();
		
		
	}

}
