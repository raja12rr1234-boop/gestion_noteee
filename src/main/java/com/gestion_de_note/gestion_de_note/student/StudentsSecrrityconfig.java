package com.gestion_de_note.gestion_de_note.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean; // 1. زدنا Import ديال @Bean
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // 2. تصحيح Import ديال HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer; // 3. زدنا Import ديال Customizer
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 4. زدنا PasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain; // 5

import com.gestion_de_note.gestion_de_note.prof.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class StudentsSecrrityconfig {

    @Autowired
    public CustomUserDetailService customUserDetailService;


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
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    public DaoAuthenticationConfigurer authnifAuthenticationConfigurer() {

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