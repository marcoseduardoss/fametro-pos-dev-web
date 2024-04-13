package br.fametro.xpto.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.fametro.xpto.Main;
/**
 *  Esta classe é necessária apenas quando você deseja criar um 
 *  arquivo WAR (Web Application Archive) para implantação em um 
 *  servidor de aplicativos servlet tradicional, como Tomcat ou 
 *  Jetty, por exemplo. 
 *  @author marcos.eduardo
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}

}
