package com.tjk.controllers;

import com.tjk.entities.Deck;
import com.tjk.services.DeckServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/master_trainer/decks")
public class DeckREST {

    @Autowired
    private DeckServiceImpl deckService;
    
    @GetMapping("/name/{deckName}")
    public Optional<Deck> getDeckByName(@PathVariable String deckName) {
        return deckService.getDeckByName(deckName);
    }
    
    @GetMapping("/user/{idUser}")
    public Optional<Deck> getDeckByIdUser(@PathVariable Integer idUser) {
        return deckService.getDeckByIdUser(idUser);
    }
    
    @GetMapping("/public")
    public Optional<Deck> getPublicDecks() {
        return deckService.getPublicDecks();
    }
    
    @GetMapping("/legal")
    public Optional<Deck> getLegalDecks() {
        return deckService.getLegalDecks();
    }
    
    @GetMapping("/{idDeck}")
    public Optional<Deck> getDeckByIdDeck(@PathVariable Integer idDeck) {
        return deckService.getDeckByIdDeck(idDeck);
    }
   
    @PostMapping
    public Deck createDeck(@RequestBody Deck deck) {
        return deckService.createDeck(deck);
    }
    
    @DeleteMapping("/{idDeck}")
    public Deck deleteDeck(@PathVariable Integer idDeck) {
        return deckService.deleteDeck(idDeck);
    }
    
    @PutMapping("/{idDeck}")
    public Deck updateDeck(@PathVariable Integer idDeck, @RequestBody Deck updatedDeck) {
        return deckService.updateDeck(idDeck, updatedDeck);
    }
}
