package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Card;
import com.tjk.repos.CardDAO;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardDAO cardRepository;

    // Adds a new card to the database. Ensures that the card is not already present.
    public Card addCard(Card card) throws IllegalArgumentException {
        // Check if the card with the given ID already exists
        Optional<Card> existingCard = cardRepository.findById(card.getIdCard());
        if (existingCard.isPresent()) {
            throw new IllegalArgumentException("A card with this ID already exists.");
        }

        // Validate required fields
        validateCard(card);

        // Save the card
        return cardRepository.save(card);
    }

    // Updates the details of an existing card. Validates required fields before updating.
    public Card updateCard(Card card) throws IllegalArgumentException {
        // Check if the card exists
        Optional<Card> existingCard = cardRepository.findById(card.getIdCard());
        if (!existingCard.isPresent()) {
            throw new IllegalArgumentException("Card not found.");
        }

        // Validate the updated card
        validateCard(card);

        // Update the card
        return cardRepository.save(card);
    }

    // Deletes a card from the database by its ID
    public void deleteCard(String idCard) throws IllegalArgumentException {
        Optional<Card> existingCard = cardRepository.findById(idCard);
        if (!existingCard.isPresent()) {
            throw new IllegalArgumentException("Card not found.");
        }

        // Delete the card
        cardRepository.delete(existingCard.get());
    }

    // Retrieves a card by its ID
    public Card getCardById(String idCard) throws IllegalArgumentException {
        Optional<Card> card = cardRepository.findById(idCard);
        if (!card.isPresent()) {
            throw new IllegalArgumentException("Card not found.");
        }
        return card.get();
    }

    // Retrieves all cards from the database
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    
    public List<Card> getCardsByName(String name) {
        return cardRepository.findByName(name);
    }

    // Validates the essential fields of the card
    private void validateCard(Card card) throws IllegalArgumentException {
        if (card.getIdCard() == null || card.getIdCard().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty.");
        }
        if (card.getName() == null || card.getName().isEmpty()) {
            throw new IllegalArgumentException("Card name cannot be null or empty.");
        }
        if (card.getSet() == null || card.getSet().isEmpty()) {
            throw new IllegalArgumentException("Card set cannot be null or empty.");
        }
        if (card.getSupertypes() == null || card.getSupertypes().isEmpty()) {
            throw new IllegalArgumentException("Card supertypes cannot be null or empty.");
        }
    }
}