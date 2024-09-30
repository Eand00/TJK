package com.tjk.entities;

import java.io.Serializable;
import java.util.Objects;

public class DeckCardsId implements Serializable {

	private Integer idCard;
	private Integer idDeck;
	
    // Default constructor
    public DeckCardsId() {
    }

	public DeckCardsId(Integer idCard, Integer idDeck) {
		super();
		this.idCard = idCard;
		this.idDeck = idDeck;
	}

	// Getters and Setters
	
	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
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
