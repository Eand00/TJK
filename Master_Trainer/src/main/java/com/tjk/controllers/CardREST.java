package com.tjk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Card;
import com.tjk.services.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("master_trainer/cards")
public class CardREST {
	
	@Autowired
	private CardService service;
	
	@GetMapping
	public List<Card> getAllCards(){
		return service.getAllCards();
	}
	
	@GetMapping("/name/{name}")
	public List<Card> getCardByName(@PathVariable String name) {
		return service.getCardsByName(name);
	}
	

}
