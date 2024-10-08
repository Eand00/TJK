package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Deck;
import com.tjk.repos.DeckDAO;
import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceImpl implements DeckCardsService{

    @Autowired
    private DeckDAO deckRepository;

    // Adds a new deck to the database
    public Deck addDeck(Deck deck) throws IllegalArgumentException {
        // Check if the deck with the given ID already exists
        Optional<Deck> existingDeck = deckRepository.findById(deck.getIdDeck());
        if (existingDeck.isPresent()) {
            throw new IllegalArgumentException("A deck with this ID already exists.");
        }

        // Validate required fields
        validateDeck(deck);

        // Save the new deck
        return deckRepository.save(deck);
    }

    // Updates an existing deck in the database
    public Deck updateDeck(Deck deck) throws IllegalArgumentException {
        // Check if the deck exists
        Optional<Deck> existingDeck = deckRepository.findById(deck.getIdDeck());
        if (!existingDeck.isPresent()) {
            throw new IllegalArgumentException("Deck not found.");
        }

        // Validate the updated deck
        validateDeck(deck);

        // Update the deck in the database
        return deckRepository.save(deck);
    }

    // Deletes a deck by its ID
    public void deleteDeck(String idDeck) throws IllegalArgumentException {
        Optional<Deck> existingDeck = deckRepository.findById(idDeck);
        if (!existingDeck.isPresent()) {
            throw new IllegalArgumentException("Deck not found.");
        }

        // Delete the deck
        deckRepository.delete(existingDeck.get());
    }

    // Retrieves a deck by its ID
    public Deck getDeckById(String idDeck) throws IllegalArgumentException {
        Optional<Deck> deck = deckRepository.findById(idDeck);
        if (!deck.isPresent()) {
            throw new IllegalArgumentException("Deck not found.");
        }
        return deck.get();
    }

    // Retrieves all decks from the database
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    // Validates the essential fields of the deck
    private void validateDeck(Deck deck) throws IllegalArgumentException {
        if (deck.getIdDeck() == null || deck.getIdDeck().isEmpty()) {
            throw new IllegalArgumentException("Deck ID cannot be null or empty.");
        }
        if (deck.getDeckName() == null || deck.getDeckName().isEmpty()) {
            throw new IllegalArgumentException("Deck name cannot be null or empty.");
        }
        if (deck.getUser() == null) {
            throw new IllegalArgumentException("Deck must have an associated user.");
        }
        if (deck.getDeckCards() == null) {
            throw new IllegalArgumentException("Deck must have a cover card.");
        }
    }

	@Override
	public void addCardToDeck(Integer deckId, String cardId, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCardFromDeck(Integer deckId, String cardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalCardsInDeck(Integer deckId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDeckValid(Integer deckId) {
		// TODO Auto-generated method stub
		return false;
	}
}
