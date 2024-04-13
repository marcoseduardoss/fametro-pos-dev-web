package br.fametro.xpto.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir solicitações de qualquer origem (use * para permitir de qualquer origem)
        config.addAllowedOrigin("*");

        // Permitir solicitações GET, POST, PUT, DELETE e OPTIONS
        config.addAllowedMethod("*");

        // Permitir os cabeçalhos específicos que seu aplicativo React envia
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
