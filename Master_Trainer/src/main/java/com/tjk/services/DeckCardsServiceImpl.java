package com.tjk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.entities.Deck;
import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;
import com.tjk.repos.CardDAO;
import com.tjk.repos.DeckCardsDAO;
import com.tjk.repos.DeckDAO;

@Service
public class DeckCardsServiceImpl implements DeckCardsService{

    @Autowired
    private DeckCardsDAO deckCardDao;
    @Autowired
    private CardDAO cardDao;
    @Autowired
    private DeckDAO deckDao;

    // Adds a card to a deck with a specified quantity
    @Override
    public void addCardToDeck(Integer deckId, String cardId, Integer quantity) throws IllegalArgumentException {
    	// Checks if the deck has slots available
	    if (getTotalCardsInDeck(deckId) >= 60) {
	    	throw new IllegalArgumentException("The deck already has 60 cards. You can't add any more cards.");
	    } else if (getTotalCardsInDeck(deckId) + quantity > 60) {
	        throw new IllegalArgumentException("Adding " + quantity + " card(s) would exceed the deck's limit of 60 cards.");
	    }
    	// Creates a DeckCardsId
    	DeckCardsId deckCardsId = new DeckCardsId(cardId,deckId);

    	// Checks if you can add any more cards with the same name in the deck
        Optional<DeckCards> existingDeckCards = deckCardDao.findById(deckCardsId);
        if (existingDeckCards.isPresent() && countCardsWithName(deckId,existingDeckCards.get().getCard().getNameCard()) >= 4 && !existingDeckCards.get().getCard().getSubtypes().contains("Energy")) {
        	throw new IllegalArgumentException("You can't add any more cards with that name.");
        }
        // Fetch the Card and Deck using respective DAOs
        Card card = cardDao.findById(cardId).orElseThrow(() -> new IllegalArgumentException("Card not found"));
        Deck deck = deckDao.findById(deckId).orElseThrow(() -> new IllegalArgumentException("Deck not found"));

        // Create the DeckCards object and set its attributes
        DeckCards deckCards = new DeckCards();
        deckCards.setId(deckCardsId);
        deckCards.setCard(card);  // Set the card
        deckCards.setDeck(deck);  // Set the deck
        deckCards.setQuantity(quantity);  // Set the quantity

        // Validate the input data
        validateDeckCards(deckCards);

        // Saves the new DeckCards entry
        deckCardDao.save(deckCards);
        
        // Checks if after adding a new card the deck is valid
        deck.setLegal(isDeckValid(deckId));
    }

    // Removes a card from a deck
    @Override
    public void removeCardFromDeck(Integer deckId, String cardId) throws IllegalArgumentException {
    	// Creates a DeckCardsId
        DeckCardsId deckCardsId = new DeckCardsId(cardId,deckId);

        // Check if the card is already in the deck
        Optional<DeckCards> existingDeckCards = deckCardDao.findById(deckCardsId);
        if (!existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("The card is not in the deck.");
        }

        // Remove the card from the deck
        deckCardDao.delete(existingDeckCards.get());
    }

    // Updates the quantity of a card in a deck
    public DeckCards updateCardQuantityInDeck(Integer deckId, String cardId, Integer newQuantity) throws IllegalArgumentException {
    	// Validate that the new quantity is a positive integer
        if (newQuantity < 1) {
            throw new IllegalArgumentException("Quantity must be bigger than 1.");
        }

        // Create a DeckCardsId using the provided deckId and cardId
        DeckCardsId deckCardsId = new DeckCardsId(cardId, deckId);

        // Fetch the existing DeckCards entry
        Optional<DeckCards> existingDeckCardsOptional = deckCardDao.findById(deckCardsId);
        if (!existingDeckCardsOptional.isPresent()) {
            throw new IllegalArgumentException("This card is not present in the deck.");
        }

        // Get the existing DeckCards object
        DeckCards existingDeckCards = existingDeckCardsOptional.get();

        // Update the quantity
        existingDeckCards.setQuantity(newQuantity);

        // Validate the updated data
        validateDeckCards(existingDeckCards);

        // Save the updated DeckCards entry to the database
        return deckCardDao.save(existingDeckCards);
    }

    @Override
	public int getTotalCardsInDeck(Integer deckId) {
    	// Creates a list of DeckCards
		List<DeckCards> cardList = deckCardDao.findByDeck_IdDeck(deckId);

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
		List<DeckCards> cardList = deckCardDao.findByDeck_IdDeck(deckId);

		// Returns false if the deck doesn't contain 60 cards
		if (getTotalCardsInDeck(deckId) != 60) {
			return false;
		}

		// A list of names of every card in the deck
		List<String> nameList = new ArrayList<>();
		for (DeckCards deckCards : cardList) {
			nameList.add(deckCards.getCard().getNameCard());
		}

		// Temporary lists
		List<DeckCards> tempCardList = cardList;
		List<String> tempNameList = nameList;

		// Removes cards and names for energy cards because there's no limit for them
		for (int i = 0; i < cardList.size(); i++) {
			if (cardList.get(i).getCard().getSupertype().equals("Energy")) {
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
	    List<DeckCards> cardList = deckCardDao.findByDeck_IdDeck(deckId);

	    int count = 0;
	    for (DeckCards deckCards : cardList) {
	        if (deckCards.getCard().getNameCard().equals(name)) {
	            count++;
	        }
	    }

	    return count;
	}

    // Retrieves all cards in a specific deck
    public List<DeckCards> getCardsInDeck(Integer idDeck) {
        return deckCardDao.findByDeck_IdDeck(idDeck);
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
