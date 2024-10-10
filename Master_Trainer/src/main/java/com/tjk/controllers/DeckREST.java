package com.tjk.controllers;

import com.tjk.entities.Deck;
import com.tjk.services.DeckServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/master_trainer/decks")
public class DeckREST {

    @Autowired
    private DeckServiceImpl service;
    
    // Get deck by name
    @GetMapping("/name/{deckName}")
    public List<Deck> getDeckByName(@PathVariable String deckName) {
        return service.getDeckByName(deckName);
    }
    
    // Get decks by user ID
    @GetMapping("/user/{idUser}")
    public List<Deck> getDeckByIdUser(@PathVariable Integer idUser) {
        return service.getDecksByIdUser(idUser);
    }
    
    // Get all public decks
    @GetMapping("/public")
    public List<Deck> getPublicDecks() {
        return service.getPublicDecks();
    }
    
    // Get all legal decks
    @GetMapping("/legal")
    public List<Deck> getLegalDecks() {
        return service.getLegalDecks();
    }
    
    // Get deck by ID
    @GetMapping("/{idDeck}")
    public Optional<Deck> getDeckByIdDeck(@PathVariable Integer idDeck) {
        return service.getDeckByIdDeck(idDeck);
    }
    
    // Create a new deck
    @PostMapping("create_deck")
    public Deck createDeck(@RequestBody Deck deck) {
        return service.createDeck(deck);
    }
    
    // Delete deck by ID
    @DeleteMapping("delete_deck/{idDeck}")
    public boolean deleteDeck(@PathVariable Integer idDeck) {
        return service.deleteDeck(idDeck);
    }
    
    // Update deck by ID
    @PutMapping("update_deck/{idDeck}")
    public Deck updateDeck(@PathVariable Integer idDeck, @RequestBody Deck updatedDeck) {
        return service.updateDeck(idDeck, updatedDeck);
    }
}
