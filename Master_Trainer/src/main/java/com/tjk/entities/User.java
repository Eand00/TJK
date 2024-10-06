package com.tjk.entities;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Annotating the class as a JPA entity to be mapped to a database table
@Entity
@Table(name = "userslogin")
public class User {

    // Declaring the user ID as the primary key with auto-incrementing strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    // Declaring a boolean to indicate if the profile is private
    @Column(name = "private_profile", nullable = false)
    private boolean isPrivate;

    // Declaring fields for the user's first name and surname
    @Column(name = "first_name")
    private String name;

    private String surname;

    // Declaring a unique username for the user, which cannot be null
    @Column(nullable = false, unique = true)
    private String username;

    // Declaring the password for the user, which cannot be null
    @Column(name = "passw", nullable = false)
    private String password;

    // Declaring a role field to define the user's role (e.g., ADMIN or USER)
    @Column(name = "role", nullable = false)
    private String role;  // User role: e.g., ADMIN or USER

    // Default constructor
    public User() {}

    // Constructor to initialize all fields
    public User(Integer idUser, boolean isPrivate, String name, String surname, String username, String password, String role) {
        this.idUser = idUser;
        this.isPrivate = isPrivate;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter and setter for user ID
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    // Getter and setter for private profile status
    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    // Getter and setter for first name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password with encryption using BCrypt
    public void setPassword(String password) {
    	this.password = password;
    }

    // Getter and setter for user role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Overriding the toString method to provide a string representation of the User object
    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", isPrivate=" + isPrivate + ", name=" + name + ", surname=" + surname
                + ", username=" + username + ", role=" + role + "]";
    }
}