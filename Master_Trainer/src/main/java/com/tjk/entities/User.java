package com.tjk.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a User in the database.
 * This class maps to the "userslogin" table in the database.
 */
@Entity
@Table(name = "userslogin")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for primary key
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(name = "private_profile", nullable = false)
    private Boolean privateProfile;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

}