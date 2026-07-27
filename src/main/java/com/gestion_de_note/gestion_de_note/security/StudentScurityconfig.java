package com.gestion_de_note.gestion_de_note.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 

@Configuration
@EnableWebSecurity
public class StudentScurityconfig {
    @Autowired
    private CustomUserDetailService customUserDetailService ;

    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
.csrf(csrf -> csrf.disable())


.authorizeHttpRequests(auth  -> auth

.requestMatchers(HttpMethod.GET, "/api/cours/**", "/api/module/**", "/api/notes/**","/api/student/**" )
.hasAnyRole("STUDENT", "ADMIN")

.requestMatchers(HttpMethod.POST, "/api/student/**")
.hasAnyRole("STUDENT","ADMIN")

.requestMatchers(HttpMethod.PUT,"/api/student/**")
.hasAnyRole("STUDENT","ADMIN")


.requestMatchers(HttpMethod.DELETE, "/api/student/**")
.hasAnyRole("ADMIN")

.anyRequest().authenticated()

)
.httpBasic(org.springframework.security.config.Customizer.withDefaults());

return http.build();

    }


    @Bean 
     public DaoAuthenticationProvider authenticationProvider() {

    
      
 DaoAuthenticationProvider  authProvider = new DaoAuthenticationProvider(); 

 authProvider.setUserDetailsService(customUserDetailService);

authProvider.setPasswordEncoder(passwordEncoder());  
return authProvider;
       
     }

     @Bean

     public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
     }
}
