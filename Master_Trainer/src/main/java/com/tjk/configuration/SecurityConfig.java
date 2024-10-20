package com.tjk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tjk.services.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    // Constructor-based injection of CustomUserDetailsService
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless services
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/resources/**").permitAll() // Allow public access to login and resources
                .requestMatchers("/master_trainer/cards/**", "/master_trainer/users/create_user").permitAll() // Allow public access to card and user creation
                .requestMatchers("/master_trainer/users/change_user_password").hasRole("ADMIN") // Only admin can change user passwords
                .anyRequest().authenticated() // All other requests require authentication
            )
            .httpBasic(Customizer.withDefaults()) // Enable Basic Authentication
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Stateless session management

        return http.build(); // Build and return the security filter chain
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // Set the user details service
        authProvider.setPasswordEncoder(passwordEncoder()); // Set the password encoder
        return authProvider; // Return the authentication provider
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Return the password encoder implementation
    }
}
