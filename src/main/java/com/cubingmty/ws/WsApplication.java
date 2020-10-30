package com.cubingmty.ws;

import java.util.Collections;

import com.google.common.collect.Lists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WsApplication {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("cubingmty-apis")
				.select()
				.paths(PathSelectors.regex("/api/v1.*")) 
				.build()
				.apiInfo(getApiInformation())
				.securitySchemes(Lists.newArrayList(apiKey()));
	}
	

	@Bean
	public Docket swaggerConfigurationCatalogs() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("cubingmty-catalogs")
				.select()
				.paths(PathSelectors.regex("/catalog.*")) 
				.build()
				.apiInfo(getCatalogApiInformation());
	}
	
	private ApiKey apiKey() {
        return new ApiKey("Bearer", AUTHORIZATION_HEADER, "header");
    }
	
	private ApiInfo getApiInformation(){
        return new ApiInfo("Cubing-mty API Documentation",
                "Cubing-mty rest service backend project",
                "1.0",
                "API Terms of Service URL",
                new Contact("Orlando Loza Castro", "orlando26.github.io", "orlandolozaarr@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
                );
    }
	
	private ApiInfo getCatalogApiInformation(){
        return new ApiInfo("Cubing-mty Catalogs Documentation",
                "Cubing-mty rest service backend project",
                "1.0",
                "API Terms of Service URL",
                new Contact("Orlando Loza Castro", "orlando26.github.io", "orlandolozaarr@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
                );
    }

}
