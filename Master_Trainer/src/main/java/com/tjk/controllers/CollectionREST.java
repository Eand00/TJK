package com.tjk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjk.entities.Collection;
import com.tjk.services.CollectionServiceImpl;

@RestController 
@RequestMapping("/master_trainer/collections") 
public class CollectionREST {

	@Autowired
	CollectionServiceImpl collectionService;

	// request to get all collections
	@GetMapping("/get_all")
	public List<Collection> getAll(){
		return collectionService.getAll();
	}
	
	// request to add a certain number of cards in the collection of a user
	@PostMapping("/add_card")
	public ResponseEntity<Collection> addCard(@RequestBody Collection collection){
		Integer idUser = collection.getUser().getIdUser();
		String idCard = collection.getCard().getIdCard();
		Integer quantity = collection.getQuantity();
		
		Collection c = collectionService.addCardToCollection(idUser, idCard, quantity);
		return ResponseEntity.ok(c);
	}

	// request to update the quantity of a card
	@PutMapping("/edit_card")
	public ResponseEntity<Collection> editCard(@RequestBody Collection collection){
		Integer idUser = collection.getUser().getIdUser();
		String idCard = collection.getCard().getIdCard();
		Integer quantity = collection.getQuantity();
		
		Collection c = collectionService.updateCardQuantity(idUser, idCard, quantity);
		return ResponseEntity.ok(c);
	}
	
	// request to delete a card for the user
	@DeleteMapping("/delete_card/{idUser}/{idCard}")
	public ResponseEntity<Void> removeCardFromCollection(@PathVariable Integer idUser, @PathVariable String idCard){
		// tries to remove the collection from the records
		// if successful returns no content
		// debug
		if(collectionService.removeCardFromCollection(idUser, idCard)) {
			return ResponseEntity.noContent().build();
		}
		// if the collection does not exist returns not found
		return ResponseEntity.notFound().build();
	}
	
	// request to mark a card in the collection as favourite
	@PutMapping("/mark_favourite/{idUser}/{idCard}")
	public ResponseEntity<Collection> markCardAsFavourite(@PathVariable Integer idUser, @PathVariable String idCard){
		Collection updatedCollection = collectionService.markCardAsFavourite(idUser, idCard);
		return ResponseEntity.ok(updatedCollection);
	}
	
	// request to get the user's favourite cards
	@GetMapping("/favourite/{idUser}")
	public List<Collection> getFavouriteCards(@PathVariable Integer idUser){
		return collectionService.getFavouriteCards(idUser);
	}
	
	// request to get the user's collections
	@GetMapping("/{idUser}")
	public List<Collection> getUserCollection(@PathVariable Integer idUser) {
		return collectionService.getUserCollection(idUser);
	}
	
	// request to get a certain card for a certain user
	@GetMapping("get_card/{idUser}/{idCard}")
	public Collection getByUserAndByCard(@PathVariable Integer idUser, @PathVariable String idCard){
		return collectionService.findByUserAndByCard(idUser, idCard);
	}
	
}
