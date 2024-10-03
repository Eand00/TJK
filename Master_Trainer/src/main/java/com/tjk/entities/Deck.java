package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Deck in the database.
 * This class maps to the "Deck" table and holds information about a deck of cards.
 */
@Entity
@Table(name = "deck")
public class Deck {
	
    /**
     * The unique identifier for the deck.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deck", nullable = false)
    private Integer idDeck;

    /**
     * The name of the deck.
     */
    @Column(name = "deck_name", nullable = false)
    private String deckName;

    /**
     * The format of the deck (nullable).
     */
    @Column(nullable = false)
    private String format;

    /**
     * Indicates if the deck is legal for tournament play.
     */
    @Column(nullable = false)
    private boolean legal;

    /**
     * Indicates if the deck is private.
     */
    @Column(name = "is_private", nullable = false)
    private boolean isPrivate;

    /**
     * The user who owns the deck. This is a many-to-one relationship.
     * Mapped by the "user_id" column.
     */
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    /**
     * TBI
     */
    @ManyToOne
    @JoinColumn(name = "cover_card", referencedColumnName = "id_card", nullable = false)
    private Card coverCard; 
    
    // Constructors
    public Deck() {}

    public Deck(Integer idDeck, String deckName, String format, boolean legal, boolean isPrivate, User user, Card coverCard) {
        this.idDeck = idDeck;
        this.deckName = deckName;
        this.format = format;
        this.legal = legal;
        this.isPrivate = isPrivate;
        this.user = user;
        this.coverCard = coverCard;
    }

    // Getters and Setters

    public Integer getIdDeck() {
        return idDeck;
    }

    public void setIdDeck(Integer idDeck) {
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

    public Card getDeckCards() {
        return coverCard;
    }

    public void setDeckCards(Card coverCard) {
        this.coverCard = coverCard;
    }
}
