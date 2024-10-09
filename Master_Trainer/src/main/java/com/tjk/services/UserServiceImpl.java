package com.tjk.services;

import com.tjk.entities.User;
import com.tjk.repos.UserDAO;

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
    private PasswordEncoder passwordEncoder;
    /**
     * Validates the given password based on specified criteria:
     * - Minimum length of 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - At least one symbol
     *
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     */
    private boolean isValidPassword(String password) {
        // Check that the length is at least 8
        if (password.length() < 8) {
            return false;
        }
        // Check for at least one uppercase letter
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }
        // Check for at least one lowercase letter
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }
        // Check for at least one digit
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }
        // Check for at least one symbol
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            return false;
        }
        return true; // Password is valid if all checks passed
    }

    @Override
    public List<User> getAllUsers() {
        return dao.findAll(); // Retrieve all users from the database
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return dao.findById(id); // Retrieve a user by their ID
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> userOptional = dao.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check if the user's profile is private
            if (user.getPrivateProfile()) {
                User userPublic = new User();
                userPublic.setUsername(user.getUsername()); // Return only the username if the profile is private
                return Optional.of(userPublic);
            } else {
                return userOptional; // Return full user details if the profile is public
            }
        }
        return Optional.empty(); // Return empty if the user is not found
    }

    @Transactional
    @Override
    public User createUser(User user) {
        // Check if username is already taken
        if (dao.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken."); // Throw exception if username exists
        }

        // Check if name and surname are not null or empty
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty."); // Throw exception if first name is empty
        }
        if (user.getSurname() == null || user.getSurname().trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be empty."); // Throw exception if surname is empty
        }

        // Validate password before creating a user
        if (!isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol."); // Throw exception if password is invalid
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user in the database
        return dao.save(user); // Save the new user to the database
    }

    @Transactional
    @Override
    public Optional<User> updateUser(Integer id, User userDetails) {
        Optional<User> userOptional = dao.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            // Validate new username if changed
            if (!existingUser.getUsername().equals(userDetails.getUsername()) &&
                dao.findByUsername(userDetails.getUsername()).isPresent()) {
                throw new IllegalArgumentException("Username is already taken."); // Throw exception if username exists
            }

            // Validate name and surname
            if (userDetails.getFirstName() == null || userDetails.getFirstName().trim().isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty."); // Throw exception if first name is empty
            }
            if (userDetails.getSurname() == null || userDetails.getSurname().trim().isEmpty()) {
                throw new IllegalArgumentException("Surname cannot be empty."); // Throw exception if surname is empty
            }

            // Optionally allow password change, ensuring it meets strength requirements
            if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                if (!isValidPassword(userDetails.getPassword())) {
                    throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol."); // Throw exception if password is invalid
                }
                existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword())); // Encode new password
            }

            // Update user details
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setSurname(userDetails.getSurname());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPrivateProfile(userDetails.getPrivateProfile());
            existingUser.setRole(userDetails.getRole());

            // Save updated user to the database
            return Optional.of(dao.save(existingUser)); // Save updated user
        }
        return Optional.empty(); // Return empty if user not found
    }

    @Override
    public boolean deleteUser(Integer id) {
        // Check if user exists before deleting
        if (dao.existsById(id)) {
            dao.deleteById(id); // Delete the user from the database
            return true; // Return true if the user was deleted successfully
        }
        return false; // Return false if user does not exist
    }

    @Override
    public Optional<String> changePassword(String username, String oldPassword, String newPassword) {
        Optional<User> userOptional = dao.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check if the old password matches
            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                // Validate the new password before updating
                if (!isValidPassword(newPassword)) {
                    throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol."); // Throw exception if password is invalid
                }
                user.setPassword(passwordEncoder.encode(newPassword)); // Encode new password
                dao.save(user); // Save updated user to the database
                return Optional.of("Password changed successfully."); // Return success message
            } else {
                return Optional.of("Incorrect old password."); // Return error message if old password is incorrect
            }
        }
        return Optional.empty(); // Return empty if user is not found
    }

    @Override
    public Optional<String> changeUserPassword(Integer id, String newPassword) {
        Optional<User> userOptional = dao.findById(id);
        if (userOptional.isPresent()) {
            // Validate the new password before updating
            if (!isValidPassword(newPassword)) {
                throw new IllegalArgumentException("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a symbol."); // Throw exception if password is invalid
            }
            User user = userOptional.get();
            user.setPassword(passwordEncoder.encode(newPassword)); // Encode new password
            dao.save(user); // Save updated user to the database
            return Optional.of("User password updated successfully."); // Return success message
        }
        return Optional.empty(); // Return empty if user is not found
    }
}