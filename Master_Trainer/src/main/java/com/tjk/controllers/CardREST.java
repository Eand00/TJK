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
import org.springframework.beans.factory.annotation.Autowired;
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
    private CardServiceImpl service;	//check if the class should be CardServiceImpl instead

    @GetMapping
    public List<Card> getAllCards(){
        return service.getAllCards();
    }

    @GetMapping("/name/{name}")
    public List<Card> getCardByName(@PathVariable String name) {
        return service.getCardsByName(name);
    }

    // New endpoint for combined filters
    @GetMapping("/search")
    public List<Card> searchCards(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer level,
        @RequestParam(required = false) String set,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String supertype) {
        return service.searchCards(name, level, set, type, supertype);
    }
}
