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
import com.tjk.services.DeckCardsServiceImpl;


@RestController
@RequestMapping("/master_trainer/deck-builder")
public class DeckCardsREST {

	@Autowired
	private DeckCardsServiceImpl service;

	// Adds a card to a deck with a specified quantity
	@PostMapping("/add-card")
	private void addCardToDeck(@RequestParam Integer idDeck,@RequestParam String idCard,@RequestParam Integer quantity) {
		service.addCardToDeck(idDeck, idCard, quantity);
	}

	// Removes a card from a deck
	@DeleteMapping("/delete-card/{deckId}/{cardId}")
    public void removeCardFromDeck(@PathVariable Integer deckId, @PathVariable String cardId) {
        service.removeCardFromDeck(deckId,cardId);
    }

	// Updates the quantity of a card in a deck
	@PutMapping("/update-quantity")
	public DeckCards updateCardQuantityInDeck(@RequestParam Integer deckId, @RequestParam String cardId, @RequestParam Integer newQuantity) {
		return service.updateCardQuantityInDeck(deckId, cardId, newQuantity);
	}

	// Retrives the number of cards in a specific deck
	@GetMapping("/total-cards/{deckId}")
	public int getTotalCardsInDeck(@PathVariable Integer deckId) {
		return service.getTotalCardsInDeck(deckId);
	}

	// Retrieves all cards in a specific deck
	@GetMapping("/cards-in-deck/{deckId}")
	public List<DeckCards> getCardsInDeck(@PathVariable Integer deckId) {
        return service.getCardsInDeck(deckId);
    }
	
	//Checks if the deck is valid or not
	@GetMapping("is-deck-valid/{deckId}")
	public ResponseEntity<String> isDeckValid(@PathVariable Integer deckId) {
		if (service.isDeckValid(deckId)) {
            return ResponseEntity.ok("The given deck is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("The given deck is not valid.");
        }
    }
}
