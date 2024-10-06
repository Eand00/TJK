package com.tjk.configuration;

import com.tjk.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.SecurityFilterChain; 

@Configuration 
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService; // Custom UserDetailsService for user authentication

    // Constructor for dependency injection of the CustomUserDetailsService
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService; // Assign the injected UserDetailsService
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
            .authorizeHttpRequests(requests -> requests
                // Allow access to login page and resources for everyone
                .requestMatchers("/login", "/resources/**").permitAll()
                // Allow access to all card-related endpoints for everyone
                .requestMatchers("/master_trainer/cards/**").permitAll()
                // Allow access to the user creation endpoint for everyone
                .requestMatchers("/master_trainer/users/create_user").permitAll()
                // Restrict access to user management endpoints to ADMIN role only
                .requestMatchers("/master_trainer/users/**").hasRole("ADMIN")
                // Require authentication for changing passwords
                .requestMatchers("/master_trainer/users/change-password").authenticated()
                // All other requests require authentication
                .anyRequest().authenticated())
            .formLogin(login -> login.permitAll()) // Allow all users to access the login form
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

    /**
     * Configures the authentication provider to use the custom user details service
     * and the password encoder.
     *
     * @return a DaoAuthenticationProvider instance configured with the custom user details service and password encoder
     */
    @Bean 
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // Create a new DaoAuthenticationProvider
        authProvider.setUserDetailsService(userDetailsService);  // Set the custom UserDetailsService for user retrieval
        authProvider.setPasswordEncoder(passwordEncoder());  // Set the password encoder for validating passwords
        return authProvider; // Return the configured DaoAuthenticationProvider
    }
}