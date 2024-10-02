package com.tjk.repos;


import com.tjk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * The {@code UserDAO} interface provides methods for accessing and manipulating
 * user entities in the database.
*/
public interface UserDAO extends JpaRepository<User, Integer> {

    /**
     * Finds a user by username.
    */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by their id.
    */
    Optional<User> findByIdUser(Integer id);

}