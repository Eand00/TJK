package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;
import com.tjk.repos.DeckCardsDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeckCardsServiceImpl implements DeckCardsService{

    @Autowired
    private DeckCardsDAO deckCardsRepository;
    /*private CardDAO cardRepository;
    private DeckDAO deckRepository;*/

    // Adds a card to a deck with a specified quantity
    @Override
    public void addCardToDeck(Integer deckId, String cardId, Integer quantity) throws IllegalArgumentException {
    	// Checks if the deck has slots available 
    	if (getTotalCardsInDeck(deckId) == 60) {
    		throw new IllegalArgumentException("The deck is full.");
    	}
    	
    	// Creates a DeckCardsId
    	DeckCardsId deckCardsId = new DeckCardsId(cardId,deckId);
    	
    	// Checks if you can add any more cards with the same name in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(deckCardsId);
        if (existingDeckCards.isPresent() && countCardsWithName(deckId,existingDeckCards.get().getCard().getName()) == 4 && !existingDeckCards.get().getCard().getSubtypes().contains("Energy")) {
        	throw new IllegalArgumentException("You can't add any more cards with that name.");
        }
        
        // Creates an object DeckCards and sets its attributes
        DeckCards deckCards = new DeckCards();
        deckCards.setCard(deckCardsRepository.findCardByCardId(cardId));
        deckCards.setDeck(deckCardsRepository.findDeckByDeckId(deckId));
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
    	String idCard = deckCards.getCard().getIdCard();
    	int idDeck = deckCards.getDeck().getIdDeck();
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
		if (getTotalCardsInDeck(deckId) != 60) {
			return false;
		}
		
		// A list of names of every card in the deck
		List<String> nameList = new ArrayList<String>(); 
		for (DeckCards deckCards : cardList) {
			nameList.add(deckCards.getCard().getName());
		}
		
		// Temporary lists
		List<DeckCards> tempCardList = cardList;
		List<String> tempNameList = nameList;
		
		// Removes cards and names for energy cards because there's no limit for them
		for (int i = 0; i < cardList.size(); i++) {
			if (cardList.get(i).getCard().getSupertypes() == "Energy") {
				tempCardList.remove(i);
				tempNameList.remove(i);
			}
		}
		
		// Checks if the deck includes more than one ACE SPEC or Radiant cards
		boolean nAceSpec = false;
		boolean nRadiant = false;
		for (int i = 0; i < tempCardList.size(); i++) {
			if (cardList.get(i).getCard().getSubtypes().contains("ACE SPEC")) {
				if (nAceSpec) {
					return false;
				}
				else {
					nAceSpec = true;
				}
			}
		
			if (cardList.get(i).getCard().getSubtypes().contains("Radiant")) {
				if (nRadiant) {
					return false;
				}
				else {
					nRadiant = true;
				}
			}
		}
		
		// Checks if the deck includes more cards with the same name than allowed (excluding energy type)
		for (int i = 0; i < tempCardList.size(); i++) {
			int nameCount = countCardsWithName(deckId,tempNameList.get(i));
			if (nameCount > 4 || (nameCount > 1 && tempCardList.get(i).getCard().getSubtypes().contains("Prism Star"))) {
				return false;
			}
		}
		
		// Checks if the deck has at least one basic pokémon in it
		int crashCounter = 0;
		for (DeckCards card : tempCardList) {
			crashCounter++; 
			if (card.getCard().getSubtypes().contains("Pokémon")) {
				break;
			}
		}
		if (crashCounter == tempCardList.size()) {
			return false;
		}
		
		return true;
		
	}
	
	// Counts the number of cards with the same name
	public int countCardsWithName(Integer deckId, String name) {
	    // Creates a list of DeckCards
	    List<DeckCards> cardList = getCardsInDeck(deckId);

	    int count = 0;
	    for (DeckCards deckCards : cardList) {
	        if (deckCards.getCard().getName().equals(name)) {
	            count++;
	        }
	    }

	    return count;
	}
	
    // Retrieves all cards in a specific deck
    public List<DeckCards> getCardsInDeck(Integer idDeck) {
        return deckCardsRepository.findAllCardsByIdDeck(idDeck);
    }

    // Validates the fields of a DeckCards entity
    private void validateDeckCards(DeckCards deckCards) throws IllegalArgumentException {
        if (deckCards.getCard().getIdCard() == null || deckCards.getCard().getIdCard().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty.");
        }
        if (deckCards.getDeck() == null || deckCards.getDeck().getIdDeck() == null) {
            throw new IllegalArgumentException("Deck ID cannot be null.");
        }
        if (deckCards.getQuantity() == null || deckCards.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer.");
        }
    }


}
