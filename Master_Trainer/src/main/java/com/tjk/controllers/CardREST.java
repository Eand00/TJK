package com.tjk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Card;
import com.tjk.exceptions.CardNotFoundException;
import com.tjk.services.CardServiceImpl;

@RestController
@RequestMapping("master_trainer/cards")
public class CardREST {

    @Autowired
    private CardServiceImpl service;

    // Retrieve all cards
    @GetMapping
    public List<Card> getAllCards() {
        return service.getAllCards();
    }

    // Retrieve a card by its name
    @GetMapping("/name/{name}")
    public List<Card> getCardByName(@PathVariable String name) {
        List<Card> cards = service.getCardsByNameCard(name);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with the name: " + name); // Throw exception if no cards found
        }
        return cards;
    }

    // Retrieve a card by its ID
    @GetMapping("/cardId/{cardId}")
    public Optional<Card> getCardByCardId(@PathVariable String cardId) {
        Optional<Card> card = service.getCardsByCardId(cardId);
        if (!card.isPresent()) {
            throw new CardNotFoundException("Card not found with ID: " + cardId); // Throw exception if card not found
        }
        return card;
    }

    // Retrieve cards by set name
    @GetMapping("/setName/{setName}")
    public List<Card> getCardBySetName(@PathVariable String setName) {
        return service.getCardsBySetName(setName);
    }

    // Retrieve cards by series
    @GetMapping("/series/{series}")
    public List<Card> getCardBySeries(@PathVariable String series) {
        return service.getCardsBySeries(series);
    }

    // Retrieve cards by publisher
    @GetMapping("/publisher/{publisher}")
    public List<Card> getCardByPublisher(@PathVariable String publisher) {
        return service.getCardsByPublisher(publisher);
    }

    // Retrieve cards by generation
    @GetMapping("/generation/{generation}")
    public List<Card> getCardByGeneration(@PathVariable String generation) {
        return service.getCardsByGeneration(generation);
    }

    // Retrieve cards by artist
    @GetMapping("/artist/{artist}")
    public List<Card> getCardByArtist(@PathVariable String artist) {
        return service.getCardsByArtist(artist);
    }

    // Retrieve cards by type
    @GetMapping("/type/{type}")
    public List<Card> getCardByTypesCard(@PathVariable String type) {
        return service.getCardsByTypesCard(type);
    }

    // Retrieve cards by supertype
    @GetMapping("/supertype/{supertype}")
    public List<Card> getCardBySupertype(@PathVariable String supertype) {
        return service.getCardsBySupertype(supertype);
    }

    // Retrieve cards by subtype
    @GetMapping("/subtype/{subtype}")
    public List<Card> getCardBySubtypes(@PathVariable String subtype) {
        return service.getCardsBySubtypes(subtype);
    }

    // Retrieve cards that evolve from a specific card
    @GetMapping("/evolvesFrom/{evolvesFrom}")
    public List<Card> getCardByEvolvesFrom(@PathVariable String evolvesFrom) {
        return service.getCardsByEvolvesFrom(evolvesFrom);
    }

    // Retrieve cards that evolve to a specific card
    @GetMapping("/evolvesTo/{evolvesTo}")
    public List<Card> getCardByEvolvesTo(@PathVariable String evolvesTo) {
        return service.getCardsByEvolvesTo(evolvesTo);
    }

    // Retrieve cards by rarity
    @GetMapping("/rarity/{rarity}")
    public List<Card> getCardByRarity(@PathVariable String rarity) {
        return service.getCardsByRarity(rarity);
    }

    // Retrieve cards by legalities
    @GetMapping("/legalities/{legalities}")
    public List<Card> getCardByLegalities(@PathVariable String legalities) {
        return service.getCardsByLegalities(legalities);
    }

    // Retrieve cards by regulation mark
    @GetMapping("/regulation/{regulation}")
    public List<Card> getCardByRegulationMark(@PathVariable String regulation) {
        return service.getCardsByRegulationMark(regulation);
    }

    // Filter cards based on various parameters
    @GetMapping("/filter")
    public List<Card> filterCards(
            @RequestParam(required = false) String nameCard,
            @RequestParam(required = false) String setName,
            @RequestParam(required = false) String series,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String generation,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String typesCard,
            @RequestParam(required = false) String supertype,
            @RequestParam(required = false) String subtypes,
            @RequestParam(required = false) String evolvesFrom,
            @RequestParam(required = false) String evolvesTo,
            @RequestParam(required = false) String rarity,
            @RequestParam(required = false) String legalities,
            @RequestParam(required = false) String regulationMark) {
        return service.filterCards(nameCard, setName, series, publisher, generation, artist, typesCard, supertype, subtypes, evolvesFrom, evolvesTo, rarity, legalities, regulationMark);
    }

    // Retrieve related cards based on a Pokemon name
    @GetMapping("/related/{pokemonName}")
    public List<Card> getRelatedCards(@PathVariable String pokemonName) {
        return service.getRelatedCards(pokemonName);
    }
    
    @GetMapping("/most_used_cards")
    public List<Object[]> getMethodName() {
        return service.getMostUsed() ;
    }
    
}
