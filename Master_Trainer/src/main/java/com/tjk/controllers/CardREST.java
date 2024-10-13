/*package com.tjk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Card;
import com.tjk.services.CardServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("master_trainer/cards")
public class CardREST {
	
	@Autowired
	private CardServiceImpl service;
	
	@GetMapping
	public List<Card> getAllCards(){
		return service.getAllCards();
	}
	
	@GetMapping("/name/{name}")
	public List<Card> getCardByName(@PathVariable String name) {
		return service.getCardsByName(name);
	}
	

}*/

package com.tjk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tjk.entities.Card;
import com.tjk.services.CardServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("master_trainer/cards")
public class CardREST {

    @Autowired
    private CardServiceImpl service;

    @GetMapping
    public List<Card> getAllCards(){
        return service.getAllCards();
    }

    @GetMapping("/name/{name}")
    public List<Card> getCardByName(@PathVariable String name) {
        return service.getCardsByNameCard(name);
    }

    @GetMapping("/cardId/{cardId}")
    public Optional<Card> getCardByCardId(@PathVariable String cardId) {
        return service.getCardsByCardId(cardId);
    }
    
    @GetMapping("/setName/{setName}")
    public List<Card> getCardBySetName(@PathVariable String setName) {
        return service.getCardsBySetName(setName);
    }
    
    @GetMapping("/series/{series}")
    public List<Card> getCardBySeries(@PathVariable String series) {
        return service.getCardsBySeries(series);
    }
    
    @GetMapping("/publisher/{publisher}")
    public List<Card> getCardByPublisher(@PathVariable String publisher) {
        return service.getCardsByPublisher(publisher);
    }
    
    @GetMapping("/generation/{generation}")
    public List<Card> getCardByGeneration(@PathVariable String generation) {
        return service.getCardsByGeneration(generation);
    }
    
    @GetMapping("/artist/{artist}")
    public List<Card> getCardByArtist(@PathVariable String artist) {
        return service.getCardsByArtist(artist);
    }
    
    @GetMapping("/type/{type}")
    public List<Card> getCardByTypesCard(@PathVariable String type) {
        return service.getCardsByTypesCard(type);
    }
    
    @GetMapping("/supertype/{supertype}")
    public List<Card> getCardBySupertype(@PathVariable String supertype) {
        return service.getCardsBySupertype(supertype);
    }
    
    @GetMapping("/subtype/{subtype}")
    public List<Card> getCardBySubtypes(@PathVariable String subtype) {
        return service.getCardsBySubtypes(subtype);
    }
    
    @GetMapping("/evolvesFrom/{evolvesFrom}")
    public List<Card> getCardByEvolvesFrom(@PathVariable String evolvesFrom) {
        return service.getCardsByEvolvesFrom(evolvesFrom);
    }
    
    @GetMapping("/evolvesTo/{evolvesTo}")
    public List<Card> getCardByEvolvesTo(@PathVariable String evolvesTo) {
        return service.getCardsByEvolvesTo(evolvesTo);
    }
    
    @GetMapping("/rarity/{rarity}")
    public List<Card> getCardByRarity(@PathVariable String rarity) {
        return service.getCardsByRarity(rarity);
    }
    
    @GetMapping("/legalities/{legalities}")
    public List<Card> getCardByLegalities(@PathVariable String legalities) {
        return service.getCardsByLegalities(legalities);
    }
    
    @GetMapping("/regulation/{regulation}")
    public List<Card> getCardByRegulationMark(@PathVariable String regulation) {
        return service.getCardsByRegulationMark(regulation);
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<Card>> filterCards(
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

        List<Card> cards = service.filterCards(nameCard, setName, series, publisher, generation, artist, typesCard, supertype, subtypes, evolvesFrom, evolvesTo, rarity, legalities, regulationMark);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
