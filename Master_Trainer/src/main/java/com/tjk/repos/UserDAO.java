package com.tjk.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.User;

/**
 * The UserDAO interface provides methods for accessing and manipulating user entities in the database.
 * It extends JpaRepository, allowing for CRUD operations and more.
 */
public interface UserDAO extends JpaRepository<User, Integer> {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to be found
     * @return an Optional containing the User object if found, or an empty Optional if not found
     */
    Optional<User> findByUsername(String username);
}