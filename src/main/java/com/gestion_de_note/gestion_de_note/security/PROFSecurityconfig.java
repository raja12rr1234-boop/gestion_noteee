package com.gestion_de_note.gestion_de_note.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer; // 👈 Import الصحيح د Spring Security
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 👈 Zدنا هادي
import org.springframework.security.crypto.password.PasswordEncoder; // 👈 Zدنا هادي
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class PROFSecurityconfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/cours/**", "/api/module/**", "/api/notes/**")
                .hasAnyRole("STUDENT", "PROF", "ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/cours/**", "/api/module/**", "/api/notes/**")
                .hasAnyRole("PROF", "ADMIN")

                .requestMatchers(HttpMethod.PUT, "/api/cours/**", "/api/module/**", "/api/notes/**")
                .hasAnyRole("PROF", "ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/prof/**", "/api/etudiant/**").hasRole("ADMIN")

                .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        // 🔹 عطيناه الـ Variable customUserDetailService
        authProvider.setUserDetailsService(customUserDetailService); 
        
        // 🔹 عطيناه passwordEncoder()
        authProvider.setPasswordEncoder(passwordEncoder()); 

        return authProvider;
    }

    // 🔑 Bean جديد لتشفير المودباسات بـ BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}