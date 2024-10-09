package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;
import com.tjk.entities.User;
import com.tjk.repos.CardDAO;
import com.tjk.repos.CollectionDAO;
import com.tjk.repos.UserDAO;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService{

    @Autowired
    private CollectionDAO collectionDAO;
    
    @Autowired
    private CardDAO cardDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    public List<Collection> getAll(){
    	return collectionDAO.findAll();
    }

    // adds quantity of a card in the collection
    // if the card is not present creates the collection with the quantity given
    @Override
	public Collection addCardToCollection(Integer idUser, String idCard, Integer quantity) {
    	Collection collection = new Collection();
    	// checks if the card is already in the collection
    	// if it is, updates the quantity with the sum of the record's quantity + given quantity
    	// else creates a new collection
    	if(collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).isPresent()) {
    		collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).orElseThrow(()-> new IllegalArgumentException("Collection not found"));
    		collection.setQuantity(collection.getQuantity() + quantity);
    	}
    	else {
    		Card card = cardDAO.findById(idCard).orElseThrow(() -> new IllegalArgumentException("Card not found"));
    		User user = userDAO.findById(idUser).orElseThrow(() -> new IllegalArgumentException("User not found"));
    		
    		CollectionId collectionId = new CollectionId(idCard, idUser);
    		collection.setId(collectionId);
    		collection.setCard(card);
    		collection.setUser(user);
    		collection.setFavourite(false);;
    		collection.setQuantity(quantity);
    	}
    	
    	// inserts or updates the record in the db
    	return collectionDAO.save(collection);
    }
    
    // changes the quantity of a card in the collection
    // if the card is not present creates the collection with the quantity given
    @Override
    public Collection updateCardQuantity(Integer idUser, String idCard, Integer newQuantity) {
    	Collection collection = new Collection();
    	// checks if the card is already in the collection
    	// if it is, updates the quantity
    	// else create a new collection
    	if(collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).isPresent()) {
    		collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
    				.orElseThrow(() -> new IllegalArgumentException("Card not found for the user"));
    		collection.setQuantity(newQuantity);
    	}
    	else {
    		CollectionId collectionId = new CollectionId(idCard, idUser);
    		collection.setId(collectionId);
    		collection.setCard(cardDAO.findByIdCard(idCard)
    				.orElseThrow(() -> new IllegalArgumentException("Card not found")));
    		collection.setUser(userDAO.findById(idUser)
    				.orElseThrow(() -> new IllegalArgumentException("User not found")));
    		collection.setFavourite(false);
    		collection.setQuantity(newQuantity);
    	}
    	
    	// inserts or updates the record in the db
    	return collectionDAO.save(collection);
    }

	// marks a card as a favourite (or unmarks if it is already)
	@Override
	public Collection markCardAsFavourite(Integer idUser, String idCard) {		
		// checks if the card is in the collection
		// if it's not, throws an exception
		if (collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).isEmpty()) {
			throw new IllegalArgumentException("The card is not in the collection");
		}
		
		// takes the collection and set the favourite flag to the opposite value
		Collection collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
				.orElseThrow(() -> new IllegalArgumentException("Card not found for the user"));
		collection.setFavourite(!collection.getFavourite());
		
		// updates the collection in the db
		return collectionDAO.save(collection);
	}

	// deletes a card of a user from his collection
	@Override
	public boolean removeCardFromCollection(Integer idUser, String idCard) {
		// checks if the card is in the collection
		// if it's not, returns false
		// else, deletes the card and returns true
		if (collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).isEmpty()) {
			return false;
		}
		// deletes the card
		collectionDAO.deleteByUser_IdUserAndCard_IdCard(idUser, idCard);
		return true;
	}
	
	// gets a list of favourite cards of a certain user
	@Override
	public List<Collection> getFavouriteCards(Integer idUser) throws IllegalArgumentException{
		// checks if the request is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findByUser_IdUserAndFavourite(idUser, true).isEmpty()) {
			throw new IllegalArgumentException("Favourites are empty");
		}		
		// calls the method to find all the favourite cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findByUser_IdUserAndFavourite(idUser, true);
	}

	// gets a list of all the cards of a certain user
	@Override
	public List<Collection> getUserCollection(Integer idUser) throws IllegalArgumentException{
		// checks if the collection requested is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findByUser_IdUser(idUser).isEmpty()) {
			throw new IllegalArgumentException("The collection is empty");
		}
		// calls the method to find all the cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findByUser_IdUser(idUser);
	}

}