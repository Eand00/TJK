package com.tjk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Collection;
import com.tjk.services.CollectionServiceImpl;

@RestController 
@RequestMapping("/master_trainer/collections") 
public class CollectionREST {

	@Autowired
	CollectionServiceImpl collectionService;
	
	// returns all collections
	@GetMapping("/get_all")
	public List<Collection> getAllCollections(){
		return collectionService.getAll();
	}
	
	@PostMapping("/add_card")
	public ResponseEntity<Collection> addCard(@RequestParam Integer idUser, @RequestParam String idCard, @RequestParam Integer quantity){
		Collection collection = collectionService.addCardToCollection(idUser, idCard, quantity);
		return ResponseEntity.ok(collection);
	}
	
}
