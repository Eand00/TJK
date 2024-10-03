package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The DeckCards entity represents the relationship between a deck and the cards within that deck.
 * This class serves as a join table, allowing the association between {@link Deck} and {@link Card} entities.
 * Each instance of DeckCards represents one card in a specific deck.
 */
@Entity
@Table(name = "decks_cards")  // Specifies the table name for this entity in the database
@IdClass(DeckCardsId.class)
public class DeckCards {

    /**
     * The card that is part of the deck. This establishes a many-to-one relationship
     * where a card can appear in multiple decks.
     * The card is referenced by the foreign key 'card_id' in the database.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_card", referencedColumnName = "id_card", nullable = false)
    private Card idCard;

    /**
     * The deck to which the card belongs. This establishes a many-to-one relationship 
     * where multiple cards can belong to a single deck.
     * The deck is referenced by the foreign key 'deck_id' in the database.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_deck", referencedColumnName = "id_deck", nullable = false)  // Foreign key to the Deck entity
    private Deck idDeck;
    
    @Column(nullable = false)
    private Integer quantity;

    // Getters and Setters
    public Integer getQuantity() {
		return quantity;
	}

	public Card getIdCard() {
		return idCard;
	}

	public void setIdCard(Card idCard) {
		this.idCard = idCard;
	}

	public Deck getIdDeck() {
		return idDeck;
	}

	public void setIdDeck(Deck idDeck) {
		this.idDeck = idDeck;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
    //To String
	
	@Override
	public String toString() {
		return "DeckCards [idCard=" + idCard + ", idDeck=" + idDeck + ", quantity=" + quantity + "]";
	}   

}

