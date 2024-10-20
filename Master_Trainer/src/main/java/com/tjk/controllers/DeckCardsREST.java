package com.tjk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.DeckCards;
import com.tjk.exceptions.DeckNotFoundException;
import com.tjk.exceptions.EmptyCollectionException;
import com.tjk.services.DeckCardsServiceImpl;

@RestController
@RequestMapping("/master_trainer/deck-builder")
public class DeckCardsREST {

    @Autowired
    private DeckCardsServiceImpl service;

    // Adds a card to a deck with a specified quantity
    @PostMapping("/add-card")
    public ResponseEntity<String> addCardToDeck(@RequestParam Integer idDeck, @RequestParam String idCard, @RequestParam Integer quantity) {
        // Check if the deck exists before adding a card
        if (!service.isDeckValid(idDeck)) {
            throw new DeckNotFoundException("Deck with ID " + idDeck + " not found.");
        }
        
        // Ensure quantity is positive
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        
        service.addCardToDeck(idDeck, idCard, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Card added to deck successfully.");
    }

    // Removes a card from a deck
    @DeleteMapping("/delete-card/{deckId}/{cardId}")
    public ResponseEntity<String> removeCardFromDeck(@PathVariable Integer deckId, @PathVariable String cardId) {
        if (!service.isDeckValid(deckId)) {
            throw new DeckNotFoundException("Deck with ID " + deckId + " not found.");
        }

        // Attempt to remove the card from the deck
        service.removeCardFromDeck(deckId, cardId);
        return ResponseEntity.ok("Card removed from deck successfully.");
    }

    // Updates the quantity of a card in a deck
    @PutMapping("/update-quantity")
    public ResponseEntity<DeckCards> updateCardQuantityInDeck(@RequestParam Integer deckId, @RequestParam String cardId, @RequestParam Integer newQuantity) {
        if (!service.isDeckValid(deckId)) {
            throw new DeckNotFoundException("Deck with ID " + deckId + " not found.");
        }

        // Ensure new quantity is positive
        if (newQuantity <= 0) {
            throw new IllegalArgumentException("New quantity must be greater than zero.");
        }

        DeckCards updatedDeckCard = service.updateCardQuantityInDeck(deckId, cardId, newQuantity);
        return ResponseEntity.ok(updatedDeckCard);
    }

    // Retrieves the number of cards in a specific deck
    @GetMapping("/total-cards/{deckId}")
    public ResponseEntity<Integer> getTotalCardsInDeck(@PathVariable Integer deckId) {
        if (!service.isDeckValid(deckId)) {
            throw new DeckNotFoundException("Deck with ID " + deckId + " not found.");
        }

        int totalCards = service.getTotalCardsInDeck(deckId);
        return ResponseEntity.ok(totalCards);
    }

    // Retrieves all cards in a specific deck
    @GetMapping("/cards-in-deck/{deckId}")
    public ResponseEntity<List<DeckCards>> getCardsInDeck(@PathVariable Integer deckId) {
        if (!service.isDeckValid(deckId)) {
            throw new DeckNotFoundException("Deck with ID " + deckId + " not found.");
        }

        List<DeckCards> cardsInDeck = service.getCardsInDeck(deckId);
        // Check if the deck is empty
        if (cardsInDeck.isEmpty()) {
            throw new EmptyCollectionException("No cards found in deck with ID " + deckId + ".");
        }

        return ResponseEntity.ok(cardsInDeck);
    }

    // Checks if the deck is valid or not
    @GetMapping("/is-deck-valid/{deckId}")
    public ResponseEntity<String> isDeckValid(@PathVariable Integer deckId) {
        if (service.isDeckValid(deckId)) {
            return ResponseEntity.ok("The given deck is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("The given deck is not valid.");
        }
    }
}
