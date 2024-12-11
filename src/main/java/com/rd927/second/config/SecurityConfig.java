package com.rd927.second.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Using the new lambda syntax to disable CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/sheporausers/create", "/api/sheporausers/login", "/error").permitAll() // Public access to register endpoint
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                );

        return http.build();
    }
}
