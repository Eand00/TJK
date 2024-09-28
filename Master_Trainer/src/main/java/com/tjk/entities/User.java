package com.tjk.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The {@code User} class represents a user entity mapped to the "User" table in the database.
 * It includes attributes such as name, surname, username, password, and privacy status.
 * The password is securely stored using the BCrypt hashing algorithm.
 * 
 * <p>
 * The class makes use of JPA annotations to define mappings to the database table and
 * uses {@link BCryptPasswordEncoder} to encrypt passwords before storing them.
 * </p>
 */
@Entity
@Table(name = "userlogin")
public class User {

	/**
     * The unique identifier for the user. This field is the primary key in the database.
     */
    @Id
    @Column(name = "id_user")
    private String idUser;

    /**
     * A boolean flag that indicates if the user's profile is private or public.
     */
    @Column(nullable = false, name = "private_profile")
    private boolean isPrivate;

    /**
     * The user's first name.
     */
    @Column(name = "first_name")
    private String name;

    /**
     * The user's surname.
     */
    private String surname;

    /**
     * The username of the user, which is unique in the database.
     * This field cannot be null.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * The password of the user, which is stored securely using BCrypt hashing.
     * This field cannot be null.
     */
    @Column(name = "passw", nullable = false)
    private String password;

    /**
     * Default constructor for the {@code User} class. This is required by JPA.
     */
    public User() {
    }

    // Constructor with parameters
    public User(boolean isPrivate, String name, String surname, String username, String password) {
        this.isPrivate = isPrivate;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Sets the user's password, automatically hashing it using the BCrypt hashing algorithm.
     * 
     * @param password the raw password to be hashed and stored
     */
    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
    
    /**
     * Returns a string representation of the {@code User} object, excluding the password.
     * 
     * @return a string containing the user’s ID, privacy status, name, surname, and username
     */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", isPrivate=" + isPrivate + ", name=" + name + ", surname=" + surname
				+ ", username=" + username + "]";
	}

}
