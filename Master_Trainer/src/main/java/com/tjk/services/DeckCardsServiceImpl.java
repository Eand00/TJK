package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.entities.Deck;
import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;
import com.tjk.repos.CardDAO;
import com.tjk.repos.DeckCardsDAO;
import com.tjk.repos.DeckDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeckCardsServiceImpl implements DeckCardsService{

    @Autowired
    private DeckCardsDAO deckCardsRepository;
    private CardDAO cardRepository;
    private DeckDAO deckRepository;

    // Adds a card to a deck with a specified quantity
    @Override
    public void addCardToDeck(Integer deckId, String cardId, Integer quantity) throws IllegalArgumentException {
    	// Checks if the deck has slots available 
    	if (getTotalCardsInDeck(deckId) == 30) {
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
        deckCards.setIdCard(cardRepository.findByIdCard(cardId).get());
        deckCards.setIdDeck(deckRepository.findByIdDeck(deckId).get());
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
    	String idCard = deckCards.getIdCard().getIdCard();
    	int idDeck = deckCards.getIdDeck().getIdDeck();
    	DeckCardsId deckCardsId = new DeckCardsId(idCard,idDeck);
    	
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
    	// Creates a list of DeckCards
		List<DeckCards> cardList = getCardsInDeck(deckId);
		
		// Adds for each card the corresponding quantity to the total
		int result = 0;
		for (DeckCards deckCard : cardList) {
			result += deckCard.getQuantity();
		}
    	return result;
	}

	@Override
	public boolean isDeckValid(Integer deckId) {
		// Creates a list of DeckCards
		List<DeckCards> cardList = getCardsInDeck(deckId);
		
		// Returns false if the deck doesn't contain 30 cards
		if (getTotalCardsInDeck(deckId) != 30) {
			return false;
		}
		
		// A list of names of every card in the deck
		List<String> nameList = new ArrayList<String>(); 
		for (DeckCards deckCards : cardList) {
			nameList.add(deckCards.getIdCard().getName());
		}
		
		
		for (int i = 0; i < cardList.size(); i++) {
			if (cardList.get(i).getIdCard().getName()==) {
				
			}
		}
			
		return true;
		
	}
	
    // Retrieves all cards in a specific deck
    public List<DeckCards> getCardsInDeck(Integer idDeck) {
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
