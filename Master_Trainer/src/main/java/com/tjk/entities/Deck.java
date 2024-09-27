package com.tjk.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Deck")
public class Deck {
	
	@Id
	private String idDeck;
	private String deckName;
	@Column(nullable = true)
	private String format;
	private boolean legal;
	private boolean privateDeck;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "deck")
	private List<DeckCards> deckCards;

}
