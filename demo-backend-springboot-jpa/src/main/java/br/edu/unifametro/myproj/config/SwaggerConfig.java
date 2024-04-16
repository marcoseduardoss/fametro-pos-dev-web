package br.edu.unifametro.myproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {
	
	@Bean // url de acesso: http://localhost:8080/swagger-ui/index.html
	public OpenAPI springShopOpenAPI() {
	    return new OpenAPI()
	            .info(new Info().title("XPTO API")
	            .description("My API")
	            .version("v0.0.1")
	            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	            .externalDocs(new ExternalDocumentation()
	            .description("My Wiki Documentation")
	            .url("https://xpto.wiki.github.org/docs"));
	}
}

