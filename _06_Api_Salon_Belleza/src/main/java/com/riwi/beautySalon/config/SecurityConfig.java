package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //1. Anotación configurar Spring Security
public class SecurityConfig {
    //2. Declarar rutas publicas
    private final String[] PUBLIC_RESOURCES = { "/services/public/get", "/auth/**"};


    /**
     *  @Bean Annotation: Esta anotación le indica a Spring  que el objeto retornado
     *  por el metodo debe ser ser registrado como un bean (friol) en el contrexto de la app
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http
            .csrf(csrf -> csrf.disable()) //Desabilitar csrf para apps monoliticas
            .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers(PUBLIC_RESOURCES).permitAll()
                .anyRequest().authenticated()
            ).build();
    }
    
}
