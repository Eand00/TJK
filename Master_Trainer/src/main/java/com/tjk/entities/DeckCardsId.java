package com.tjk.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class DeckCardsId implements Serializable {

    @Column(name = "id_card")
	private String idCard;
    
    @Column(name = "id_deck")                        
	private Integer idDeck;
	           
    // Default constructor
    public DeckCardsId() {
    }

	public DeckCardsId(String idCard, Integer idDeck) {
		super();
		this.idCard = idCard;
		this.idDeck = idDeck;
	}

	// Getters and Setters
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getIdDeck() {
		return idDeck;
	}

	public void setIdDeck(Integer idDeck) {
		this.idDeck = idDeck;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCard, idDeck);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeckCardsId other = (DeckCardsId) obj;
		return Objects.equals(idCard, other.idCard) && Objects.equals(idDeck, other.idDeck);
	}
    
    // hashCode and equals (important for composite keys)

	
    
	
}
