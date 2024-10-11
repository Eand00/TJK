package com.tjk.services;

import java.util.List;
import java.util.Optional;

import com.tjk.entities.Deck;

public interface DeckService {

    // Get decks by name
    public List<Deck> getDeckByName(String deckName);
    
    // Get decks by user ID
    public List<Deck> getDecksByIdUser(Integer idUser);
    
    // Get public decks
    public List<Deck> getPublicDecks();
    
    // Get legal decks
    public List<Deck> getLegalDecks();
    
    // Get deck by deck ID
    public Optional<Deck> getDeckByIdDeck(Integer idDeck);
    
    // Validate deck
    public boolean isDeckValid(Deck deck);
    
    // Create a new deck
    public Deck createDeck(Deck deck);
    
    // Delete deck by ID
    public boolean deleteDeck(Integer idDeck);
    
    // Update deck by ID
    public Deck updateDeck(Integer idDeck, Deck updatedDeck);
}