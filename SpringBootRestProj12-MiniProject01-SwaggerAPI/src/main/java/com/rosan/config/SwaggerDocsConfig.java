package com.rosan.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // UI screen type
				.select() // to specify RestControllers
				.apis(RequestHandlerSelectors.basePackage("com.rosan.controller"))// base pkg for RestControllers
				.paths(PathSelectors.regex("/tourist.*")) // to specify request paths
				.build()// builds the Docket object
				.useDefaultResponseMessages(false).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("raja", "http://www.HCL.com/tourist", "raja@gmail.com");
		return new ApiInfo("Tourist API", "Gives info about Tourist Activities", "3.4 RELEASE",
				"http://www.hcl.com/license", contact, "GNU Public", "http://apache.org/license/gnu",
				Collections.emptyList());
	}
}
