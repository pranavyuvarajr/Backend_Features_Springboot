package com.pranav.Backend_Features_Springboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .cors(c -> c.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/").permitAll()
                                .anyRequest().authenticated()
                )
//                .formLogin(form -> form
//                        .loginPage("/login").permitAll()
//                )
//                .logout(t -> t.permitAll())
                .build();
    }
}
