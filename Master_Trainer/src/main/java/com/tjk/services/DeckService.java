package com.tjk.services;

import java.util.List;
import java.util.Optional;

import com.tjk.entities.Deck;

public interface DeckService {

	public List<Deck> getDeckByName(String deckName);
	public List<Deck> getDecksByIdUser(Integer idUser);
	public List<Deck> getPublicDecks();
	public List<Deck> getLegalDecks();
	public Optional<Deck> getDeckByIdDeck(Integer idDeck);
	public boolean isDeckValid(Deck deck);
	public Deck createDeck(Deck deck);
	public boolean deleteDeck(Integer idDeck);
	public Deck updateDeck(Integer idDeck, Deck updatedDeck);
}
