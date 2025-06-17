package br.fatec.BackEndWeb.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir requisições para todas as URLs da API
                .allowedOrigins("http://localhost:4200") // Permitir requisições exclusivamente do Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Aceitar todos os cabeçalhos HTTP
                .allowCredentials(true); // Permitir envio de cookies/autenticação (se necessário)
    }
}