package com.tjk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tjk.entities.User;
import com.tjk.repos.UserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO; // DAO for accessing User data

    /**
     * Loads user details by username for authentication.
     *
     * @param username the username of the user to load
     * @return UserDetails containing user information for authentication
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve the user from the database by username
        Optional<User> userOptional = userDAO.findByUsername(username);

        // Check if user exists
        if (userOptional.isPresent()) {
            User user = userOptional.get(); // Get the user from the Optional
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username); // Create a UserBuilder

            // Set the password and roles for the user
            builder.password(user.getPassword()); // Set the user's password
            builder.roles(user.getRole()); // Set the user's roles (assumed to be a String)

            return builder.build(); // Build and return the UserDetails object
        } else {
            // Throw exception if user is not found
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}