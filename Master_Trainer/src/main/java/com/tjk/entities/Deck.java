package com.tjk.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a Deck in the database.
 * This class maps to the "decks" table and holds information about a deck of cards.
 */
@Entity
@Table(name = "decks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Deck {

    // Primary key: Deck ID
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deck", nullable = false)
    private Integer idDeck;

    // Deck name (cannot be null)
    @Column(name = "deck_name", nullable = false)
    private String deckName;

    // Format of the deck (cannot be null)
    @Column(name = "format", nullable = false)
    private String format;

    // Legal status of the deck (cannot be null)
    @Column(name = "legal", nullable = false)
    private Boolean legal;

    // Privacy status (cannot be null)
    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    // Many decks can belong to one user (foreign key: id_user)
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    // Many decks can have one cover card (foreign key: cover_card)
    @ManyToOne
    @JoinColumn(name = "cover_card", referencedColumnName = "id_card", nullable = false)
    private Card coverCard;
}