package com.tjk.configuration;

import com.tjk.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.SecurityFilterChain; 

@Configuration 
public class SecurityConfig {

    // Constructor for dependency injection of the CustomUserDetailsService
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
    }

    /**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http the HttpSecurity object to configure
     * @return a SecurityFilterChain object with the specified security configuration
     * @throws Exception if an error occurs during configuration
     */
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests
                // Allow access to login page and resources for everyone
                .requestMatchers("/login", "/resources/**").permitAll()
                // Allow access to all card-related endpoints for everyone
                .requestMatchers("/master_trainer/cards/**", "master_trainer/decks/**").permitAll()
                // Allow access to the user creation endpoint for everyone
                .requestMatchers("/master_trainer/users/create_user").permitAll()
                // Restrict access to user management endpoints to ADMIN role only
                .requestMatchers("/master_trainer/users/**").hasRole("ADMIN")
                // Require authentication for changing passwords, delete user and update user
                .requestMatchers("/master_trainer/users/change-password", "/master_trainer/users/delete-user/**", "/master_trainer/update-user/**" ).authenticated()
                // All other requests require authentication
                .anyRequest().authenticated())
            .logout(logout -> logout.permitAll()); // Allow all users to log out
        
        return http.build(); // Build and return the configured SecurityFilterChain
    }

    /**
     * Provides a PasswordEncoder bean for password encoding.
     *
     * @return a PasswordEncoder instance using BCrypt
     */
    @Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Return a new BCryptPasswordEncoder for encoding passwords
    }
}