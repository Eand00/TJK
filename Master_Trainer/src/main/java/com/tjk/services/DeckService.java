package com.tjk.services;

import java.util.Optional;

import com.tjk.entities.Deck;

public interface DeckService {

	public Optional<Deck> getDeckByName(String deckName);
	public Optional<Deck> getDeckByIdUser(Integer idUser);
	public Optional<Deck> getPublicDecks();
	public Optional<Deck> getLegalDecks();
	public Optional<Deck> getDeckByIdDeck(Integer idDeck);
	public boolean isDeckValid(Integer deckId);
	public Deck createDeck(Deck deck);
	public Deck deleteDeck(Integer idDeck);
	public Deck updateDeck(Integer idDeck, Deck updatedDeck);
}
