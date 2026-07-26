package com.gestion_de_note.gestion_de_note.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gestion_de_note.gestion_de_note.prof.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class StudentsSecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/cours/**", "/api/module/**", "/api/notes/**")
                    .hasAnyRole("STUDENT", "PROF", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/student/**")
                    .hasAnyRole("STUDENT", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/student/**")
                    .hasAnyRole("STUDENT", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/student/**")
                    .hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // 💡 تصحيح 1 و 2: زدنا @Bean و صلحنا الـ Return Type لـ DaoAuthenticationProvider
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}