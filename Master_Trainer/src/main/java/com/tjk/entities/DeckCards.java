package com.tjk.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The DeckCards entity represents the relationship between a deck and the cards within that deck.
 * This class serves as a join table, allowing the association between {@link Deck} and {@link Card} entities.
 * Each instance of DeckCards represents one card in a specific deck.
 */
@Entity
@Table(name = "DeckCards")  // Specifies the table name for this entity in the database
public class DeckCards {

    /**
     * The unique identifier for each DeckCards entry.
     * This ID uniquely identifies the relationship between a Deck and a Card.
     */
    @Id
    private String id;

    /**
     * The deck to which the card belongs. This establishes a many-to-one relationship 
     * where multiple cards can belong to a single deck.
     * The deck is referenced by the foreign key 'deck_id' in the database.
     */
    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false)  // Foreign key to the Deck entity
    private Deck deck;

    /**
     * The card that is part of the deck. This establishes a many-to-one relationship
     * where a card can appear in multiple decks.
     * The card is referenced by the foreign key 'card_id' in the database.
     */
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)  // Foreign key to the Card entity
    private Card card;
    
    private Integer quantity;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
   
    

    //To String
    
    public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
    public String toString() {
        return "DeckCards [id=" + id + ", deck=" + deck + ", card=" + card + "]";
    }
}

