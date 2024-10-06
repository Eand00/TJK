package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;
import com.tjk.repos.DeckCardsDAO;
import java.util.List;
import java.util.Optional;

@Service
public class DeckCardsServiceImpl implements DeckCardsService{

    @Autowired
    private DeckCardsDAO deckCardsRepository;

    // Adds a card to a deck with a specified quantity
    @Override
    public void addCardToDeck(Integer deckId, String cardId, Integer quantity) throws IllegalArgumentException {
    	// Checks if the deck has slots available 
    	int totalCardsInDeck = getTotalCardsInDeck(deckId);
    	if (totalCardsInDeck == 30) {
    		throw new IllegalArgumentException("The deck is full.");
    	}
    	
    	// Creates a DeckCardsId
    	DeckCardsId deckCardsId = new DeckCardsId(cardId,deckId);
    	
    	// Check if the card is already in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(deckCardsId);
        if (existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("This card is already in the deck.");
        }
        
        // Creates an object DeckCards and sets its attributes
        DeckCards deckCards = new DeckCards();
        deckCards.setIdCard(cardId);
        deckCards.setIdDeck(deckId);
        deckCards.setQuantity(quantity);

        // Validate the input data
        validateDeckCards(deckCards);
        
        // Saves the new DeckCards entry
        deckCardsRepository.save(deckCards);
    }
    
    // Removes a card from a deck
    @Override
    public void removeCardFromDeck(Integer deckId, String cardId) throws IllegalArgumentException {
    	// Creates a DeckCardsId
        DeckCardsId deckCardsId = new DeckCardsId(cardId,deckId);
        
        // Check if the card is already in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(deckCardsId);
        if (!existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("The card is not in the deck.");
        }

        // Remove the card from the deck
        deckCardsRepository.delete(existingDeckCards.get());
    }
    
    // Updates the quantity of a card in a deck
    public DeckCards updateCardInDeck(DeckCards deckCards) throws IllegalArgumentException {
    	// Creates a DeckCardsId
    	DeckCardsId deckCardsId = new DeckCardsId(deckCards.getIdCard(),deckCards.getIdDeck());
    	
        // Check if the card is in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(deckCardsId);
        if (!existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("This card is not present in the deck.");
        }

        // Validate the updated data
        validateDeckCards(deckCards);

        // Update the DeckCards entry in the database
        return deckCardsRepository.save(deckCards);
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
    //-----------------------------------------------------------------------------------
    // Retrieves all cards in a specific deck
    public List<DeckCards> getCardsInDeck(String idDeck) {
        return deckCardsRepository.findAllCardsByIdDeck(idDeck);
    }

    // Validates the fields of a DeckCards entity
    private void validateDeckCards(DeckCards deckCards) throws IllegalArgumentException {
        if (deckCards.getIdCard() == null || deckCards.getIdCard().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty.");
        }
        if (deckCards.getIdDeck() == null || deckCards.getIdDeck().getIdDeck() == null) {
            throw new IllegalArgumentException("Deck ID cannot be null.");
        }
        if (deckCards.getQuantity() == null || deckCards.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer.");
        }
    }


}
