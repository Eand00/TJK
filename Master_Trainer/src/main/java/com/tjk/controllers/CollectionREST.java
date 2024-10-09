package com.tjk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Collection;
import com.tjk.entities.User;
import com.tjk.services.CollectionServiceImpl;

@RestController 
@RequestMapping("/master_trainer/collections") 
public class CollectionREST {

	@Autowired
	CollectionServiceImpl collectionService;
	
	// request to get all collections
	@GetMapping("/get_all")
	public List<Collection> getAllCollections(){
		return collectionService.getAll();
	}
	
	// request to take a collection and insert it in the db
	@PostMapping("/add_card")
	public ResponseEntity<Collection> addCard(@RequestBody Collection collection){
		Integer idUser = collection.getUser().getIdUser();
		String idCard = collection.getCard().getIdCard();
		Integer quantity = collection.getQuantity();
		
		Collection c = collectionService.addCardToCollection(idUser, idCard, quantity);
		return ResponseEntity.ok(c);
	}
	
	/*
	 * updateCardQuantity
	 * removeCardFromCollection
	 * markCardAsFavourite
	 * 
	 */
	
	// request to get the user's favourite cards
	// TODO test
	@GetMapping("/favourite/{idUser}")
	public List<Collection> getFavouriteCards(@PathVariable Integer idUser){
		return collectionService.getFavouriteCards(idUser);
	}
	
	// request to get the user's collections
	@GetMapping("/{idUser}")
	public List<Collection> getUserCollection(@PathVariable Integer idUser) {
		return collectionService.getUserCollection(idUser);
	}
	
}
