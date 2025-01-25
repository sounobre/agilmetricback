package com.agilmetric.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica o CORS a todas as rotas
                        .allowedOrigins("*") // Permite todas as origens
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite todos os métodos HTTP
                        .allowedHeaders("*"); // Permite todos os cabeçalhos
            }
        };
    }
}
