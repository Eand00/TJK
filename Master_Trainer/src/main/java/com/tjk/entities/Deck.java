package com.tjk.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity class representing a Deck in the database.
 * This class maps to the "Deck" table and holds information about a deck of cards.
 */
@Entity
@Table(name = "Deck")
public class Deck {
	
    /**
     * The unique identifier for the deck.
     */
    @Id
    private String idDeck;

    /**
     * The name of the deck.
     */
    private String deckName;

    /**
     * The format of the deck (nullable).
     */
    @Column(nullable = true)
    private String format;

    /**
     * Indicates if the deck is legal for tournament play.
     */
    private boolean legal;

    /**
     * Indicates if the deck is private.
     */
    private boolean isPrivate;

    /**
     * The user who owns the deck. This is a many-to-one relationship.
     * Mapped by the "user_id" column.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * The list of deck cards. This is a one-to-many relationship with the DeckCards entity.
     * Mapped by the "deck" field in the DeckCards entity.
     */
    @OneToMany(mappedBy = "deck")
    private List<DeckCards> deckCards;
    
    // Constructors
    public Deck() {}

    public Deck(String idDeck, String deckName, String format, boolean legal, boolean privateDeck, User user, List<DeckCards> deckCards) {
        this.idDeck = idDeck;
        this.deckName = deckName;
        this.format = format;
        this.legal = legal;
        this.isPrivate = privateDeck;
        this.user = user;
        this.deckCards = deckCards;
    }

    // Getters and Setters

    public String getIdDeck() {
        return idDeck;
    }

    public void setIdDeck(String idDeck) {
        this.idDeck = idDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }
 boolean isPrivateDeck() {
        return isPrivate;
    }

    public void setPrivateDeck(boolean privateDeck) {
        this.isPrivate = privateDeck;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DeckCards> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(List<DeckCards> deckCards) {
        this.deckCards = deckCards;
    }
}
