package com.tjk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Deck;
import com.tjk.exceptions.DeckNotFoundException;
import com.tjk.exceptions.EmptyCollectionException;
import com.tjk.services.DeckServiceImpl;

@RestController
@RequestMapping("/master_trainer/decks")
public class DeckREST {

    @Autowired
    private DeckServiceImpl service;

    // Get deck by name
    @GetMapping("/name/{deckName}")
    public ResponseEntity<List<Deck>> getDeckByName(@PathVariable String deckName) {
        List<Deck> decks = service.getDeckByName(deckName);
        // Check if any decks were found
        if (decks.isEmpty()) {
            throw new EmptyCollectionException("No decks found with the name: " + deckName);
        }
        return ResponseEntity.ok(decks);
    }

    // Get decks by user ID
    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Deck>> getDeckByIdUser(@PathVariable Integer idUser) {
        List<Deck> decks = service.getDecksByIdUser(idUser);
        // Check if any decks were found
        if (decks.isEmpty()) {
            throw new EmptyCollectionException("No decks found for user ID: " + idUser);
        }
        return ResponseEntity.ok(decks);
    }

    // Get all public decks
    @GetMapping("/public")
    public ResponseEntity<List<Deck>> getPublicDecks() {
        List<Deck> publicDecks = service.getPublicDecks();
        // Check if any public decks were found
        if (publicDecks.isEmpty()) {
            throw new EmptyCollectionException("No public decks available.");
        }
        return ResponseEntity.ok(publicDecks);
    }

    // Get all legal decks
    @GetMapping("/legal")
    public ResponseEntity<List<Deck>> getLegalDecks() {
        List<Deck> legalDecks = service.getLegalDecks();
        // Check if any legal decks were found
        if (legalDecks.isEmpty()) {
            throw new EmptyCollectionException("No legal decks available.");
        }
        return ResponseEntity.ok(legalDecks);
    }

    // Get deck by ID
    @GetMapping("/{idDeck}")
    public ResponseEntity<Deck> getDeckByIdDeck(@PathVariable Integer idDeck) {
        Optional<Deck> deck = service.getDeckByIdDeck(idDeck);
        // Check if the deck exists
        if (deck.isEmpty()) {
            throw new DeckNotFoundException("Deck with ID " + idDeck + " not found.");
        }
        return ResponseEntity.ok(deck.get());
    }

    // Create a new deck
    @PostMapping("/create_deck")
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck createdDeck = service.createDeck(deck);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDeck);
    }

    // Delete deck by ID
    @DeleteMapping("/delete_deck/{idDeck}")
    public ResponseEntity<String> deleteDeck(@PathVariable Integer idDeck) {
        if (!service.deleteDeck(idDeck)) {
            throw new DeckNotFoundException("Deck with ID " + idDeck + " not found.");
        }
        return ResponseEntity.ok("Deck deleted successfully.");
    }

    // Update deck by ID
    @PutMapping("/update_deck/{idDeck}")
    public ResponseEntity<Deck> updateDeck(@PathVariable Integer idDeck, @RequestBody Deck updatedDeck) {
        // Check if the deck exists before updating
        if (!service.getDeckByIdDeck(idDeck).isPresent()) {
            throw new DeckNotFoundException("Deck with ID " + idDeck + " not found.");
        }
        Deck deck = service.updateDeck(idDeck, updatedDeck);
        return ResponseEntity.ok(deck);
    }
}
