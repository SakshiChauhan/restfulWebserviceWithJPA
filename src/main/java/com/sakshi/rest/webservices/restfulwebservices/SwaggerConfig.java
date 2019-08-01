package com.sakshi.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Salshi Chauhan", "www.sakshijayant.com", "sakshi.uiet@gmail.com");
	public static final ApiInfo DEFAULT = new ApiInfo("My Api Documentation", "Api description created by Sakshi", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	private Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/JSON","application/XML"));

	// For default config
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2); 
//	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(DEFAULT_PRODUCES_AND_CONSUMES);
		//in same way change consumes and other properties... improve documentation
	}
}
