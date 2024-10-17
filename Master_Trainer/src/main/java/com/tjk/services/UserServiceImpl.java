package com.tjk.services;

import com.tjk.entities.User;
import com.tjk.repos.UserDAO;
import com.tjk.exceptions.UserNotFoundException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao; 
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Encoder for hashing passwords before saving to the database

    // Validates if the given password meets complexity requirements (length, uppercase, lowercase, digit, and special character)
    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false; // Password should be at least 8 characters long
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false; // Must contain an uppercase letter
        if (!Pattern.compile("[a-z]").matcher(password).find()) return false; // Must contain a lowercase letter
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false; // Must contain a digit
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false; // Must contain a special character
        return true;
    }

    // Retrieves a list of all users in the database
    @Override
    public List<User> getAllUsers() {
        return dao.findAll();
    }

    // Retrieves a user by their ID, throws an exception if not found
    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.ofNullable(dao.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found.")));
    }

    // Retrieves a user by their username. If the user's profile is private, only returns the username
    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> userOptional = dao.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPrivateProfile()) {
                // If the profile is private, return only the username
                User userPublic = new User();
                userPublic.setUsername(user.getUsername());
                return Optional.of(userPublic);
            } else {
                return userOptional;
            }
        }
        throw new UserNotFoundException("User with username " + username + " not found.");
    }

    // Creates a new user. Ensures the username is unique and the password is valid, then saves the user with a hashed password
    @Transactional
    @Override
    public User createUser(User user) {
        // Ensure username is unique
        if (dao.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }
        // Validate non-empty first name and surname
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (user.getSurname() == null || user.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty.");
        }
        // Validate the password against the rules defined in isValidPassword()
        if (!isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol.");
        }

        // Hash the password and save the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return dao.save(user);
    }

    // Updates user details. Ensures the username is unique and validates new passwords if they are being changed
    @Transactional
    @Override
    public Optional<User> updateUser(Integer id, User userDetails) {
        User existingUser = dao.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
        
        // Ensure username is unique if it's being changed
        if (!existingUser.getUsername().equals(userDetails.getUsername()) &&
            dao.findByUsername(userDetails.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        // Validate non-empty first name and surname
        if (userDetails.getFirstName() == null || userDetails.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (userDetails.getSurname() == null || userDetails.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty.");
        }

        // If a new password is provided, validate it and update
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            if (!isValidPassword(userDetails.getPassword())) {
                throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol.");
            }
            existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }

        // Update user details with the new information
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setSurname(userDetails.getSurname());
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPrivateProfile(userDetails.getPrivateProfile());
        existingUser.setRole(userDetails.getRole());

        return Optional.of(dao.save(existingUser));
    }

    // Deletes a user by their ID. Throws an exception if the user is not found
    @Override
    public boolean deleteUser(Integer id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
            return true;
        }
        throw new UserNotFoundException("User with ID " + id + " not found.");
    }

    // Changes the password for a user, validating the old password and checking the strength of the new one
    @Override
    public Optional<String> changePassword(String username, String oldPassword, String newPassword) {
        User user = dao.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found."));

        // Verify the old password matches
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            // Ensure the new password meets complexity requirements
            if (!isValidPassword(newPassword)) {
                throw new IllegalArgumentException("Password is too weak: Must contain an uppercase letter, a lowercase letter, a digit, and a symbol.");
            }
            // Hash and update the new password
            user.setPassword(passwordEncoder.encode(newPassword));
            dao.save(user);
            return Optional.of("Password changed successfully.");
        } else {
            throw new IllegalArgumentException("Old password is incorrect.");
        }
    }

    // Admin functionality to directly change a user's password by ID, without requiring the old password
    @Override
    public Optional<String> changeUserPassword(Integer id, String newPassword) {
        User user = dao.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
        
        // Validate the new password
        if (!isValidPassword(newPassword)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol.");
        }

        // Hash the new password and update
        user.setPassword(passwordEncoder.encode(newPassword));
        dao.save(user);
        return Optional.of("User password updated successfully.");
    }
}
