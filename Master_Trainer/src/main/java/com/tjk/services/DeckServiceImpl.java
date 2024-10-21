 package com.tjk.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.entities.Deck;
import com.tjk.entities.DeckCards;
import com.tjk.exceptions.DeckNotFoundException;
import com.tjk.exceptions.DeckValidationException;
import com.tjk.repos.DeckCardsDAO;
import com.tjk.repos.DeckDAO;

import jakarta.transaction.Transactional;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckDAO dao;
    @Autowired
    private DeckCardsDAO deckCardDAO;

    // Get decks by name
    @Override
    public List<Deck> getDeckByName(String deckName) {
        List<Deck> decks = dao.findByDeckName(deckName);

        if (decks.isEmpty()) {
            throw new DeckNotFoundException("No decks found with the name: " + deckName);
        }

        return decks;
    }

    // Get decks by user ID
    @Override
    public List<Deck> getDecksByIdUser(Integer idUser) {
        List<Deck> decks = dao.findByUser_IdUser(idUser);
        if (!decks.isEmpty()) {
            return decks;
        }
        throw new DeckNotFoundException("User doesn't have any decks");
    }

    // Get public decks
    @Override
    public List<Deck> getPublicDecks() {
        List<Deck> publicDecks = dao.findByIsPrivate(false);
        if (!publicDecks.isEmpty()) {
            return publicDecks;
        }
        throw new DeckNotFoundException("User doesn't have any public decks");
    }

    // Get legal decks
    @Override
    public List<Deck> getLegalDecks() {
        List<Deck> legalDecks = dao.findByLegal(true);
        if (!legalDecks.isEmpty()) {
            return legalDecks;
        }
        throw new DeckNotFoundException("User doesn't have any legal decks");
    }

    // Get deck by ID
    @Override
    public Optional<Deck> getDeckByIdDeck(Integer idDeck) {
        Optional<Deck> deck = dao.findById(idDeck);
        if (deck.isPresent()) {
            return deck;
        }
        throw new DeckNotFoundException("No deck found with id: " + idDeck);
    }

    // Validate deck fields
    @Override
    public boolean isDeckValid(Deck deck) {
        if (deck == null) {
            throw new DeckValidationException("Deck cannot be null");
        }
        if (deck.getDeckName() == null || deck.getDeckName().trim().isEmpty()) {
            throw new DeckValidationException("Deck name cannot be null or empty");
        }
        if (deck.getFormat() == null || deck.getFormat().trim().isEmpty()) {
            throw new DeckValidationException("Deck format cannot be null or empty");
        }
        if (deck.getLegal() == null) {
            throw new DeckValidationException("Legal status must be specified");
        }
        if (deck.getIsPrivate() == null) {
            throw new DeckValidationException("Privacy status must be specified");
        }
        if (deck.getUser() == null) {
            throw new DeckValidationException("User not found with id: " + deck.getUser().getIdUser());
        }
        if (deck.getCoverCard() == null) {
            throw new DeckValidationException("Cover card not found with id: " + deck.getCoverCard().getIdCard());
        }
        return true;
    }

    // Create a new deck
    @Transactional
    @Override
    public Deck createDeck(Deck deck) {
    	// Sets deck as illegal by default
    	deck.setLegal(false);
        if (isDeckValid(deck)) {
            return dao.save(deck);
        }
        throw new DeckValidationException("Deck could not be created!");
    }

    // Delete deck by ID
    @Override
    public boolean deleteDeck(Integer idDeck) {
        Optional<Deck> deckOptional = dao.findById(idDeck);
        if (deckOptional.isPresent()) {
            dao.delete(deckOptional.get());
            return true;
        } else {
            throw new DeckNotFoundException("Deck with id " + idDeck + " not found.");
        }
    }

    // Update deck by ID
    @Transactional
    @Override
    public Deck updateDeck(Integer idDeck, Deck updatedDeck) {
        Optional<Deck> deckOptional = dao.findById(idDeck);
        if (deckOptional.isPresent()) {
            Deck existingDeck = deckOptional.get();
            if (isDeckValid(updatedDeck)) {
                existingDeck.setDeckName(updatedDeck.getDeckName());
                existingDeck.setFormat(updatedDeck.getFormat());
                existingDeck.setLegal(false);
                existingDeck.setIsPrivate(updatedDeck.getIsPrivate());
                existingDeck.setUser(updatedDeck.getUser());
                existingDeck.setCoverCard(updatedDeck.getCoverCard());
                return dao.save(existingDeck);
            }
        }
        throw new DeckNotFoundException("Deck with id " + idDeck + " not found.");
    }

    // Generates a test hand of 7 random cards from a specific deck
    public List<Card> testHand(Integer idDeck) {
        Optional<Deck> deckOptional = dao.findById(idDeck);
        if (deckOptional.isPresent()) {

        	Deck deck = deckOptional.get();

            // Fetch the list of DeckCards
            List<DeckCards> deckCards = deckCardDAO.findByDeck_IdDeck(idDeck);

            // Create a list to represent the full pool of cards, considering quantities
            List<Card> cardPool = new ArrayList<>();

            for (DeckCards deckCard : deckCards) {
                // Add each card to the pool based on its quantity in the deck
                for (int i = 0; i < deckCard.getQuantity(); i++) {
                    cardPool.add(deckCard.getCard());
                }
            }

            // Shuffle the pool of cards
            Collections.shuffle(cardPool, new Random());

            // Draw the first 7 cards from the shuffled pool
            List<Card> firstHand = new ArrayList<>();
            for (int i = 0; i < 7 && i < cardPool.size(); i++) {
                firstHand.add(cardPool.get(i));
            }

            // Return the first 7 cards drawn
            return firstHand;
        } else {
            throw new DeckNotFoundException("Deck with id " + idDeck + " not found.");
        }
    }
}
