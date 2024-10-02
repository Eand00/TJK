package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.User;
import com.tjk.repos.UserDAO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*
      Creates a new user with the given information.
      This method checks for several restrictions before saving the user.
    */
    public User createUser(User user) throws IllegalArgumentException {
        // Check if username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        // Check if name and surname are not null or empty
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (user.getSurname() == null || user.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty.");
        }

        // Validate the strength of the password
        if (!isPasswordStrong(user.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain at least one number, one uppercase letter, and one special character.");
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user in the database
        return userRepository.save(user);
    }

    /*
      Updates the user's information.
      Ensures that certain fields are not null or invalid.
    */
    
    public User updateUser(String id, User updatedUser) throws IllegalArgumentException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("User not found.");
        }

        User existingUser = optionalUser.get();

        // Validate new username if changed
        if (!existingUser.getUsername().equals(updatedUser.getUsername()) &&
            userRepository.findByUsername(updatedUser.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        // Validate name and surname
        if (updatedUser.getName() == null || updatedUser.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (updatedUser.getSurname() == null || updatedUser.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty.");
        }

        // Optionally allow password change, ensuring it meets strength requirements.
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            if (!isPasswordStrong(updatedUser.getPassword())) {
                throw new IllegalArgumentException("Password must be strong.");
            }
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setPrivate(updatedUser.isPrivate());

        // Save the updated user
        return userRepository.save(existingUser);
    }

    // Deletes a user by ID
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    // Retrieves a user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /*
      Checks if a password meets the strength requirements.
      The password should be at least 8 characters long, 
      contain at least one number, one uppercase letter, and one special character.
    */
    private boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasDigit && hasSpecialChar;
    }
}