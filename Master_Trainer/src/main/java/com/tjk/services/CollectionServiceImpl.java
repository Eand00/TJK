package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Collection;
import com.tjk.repos.CollectionDAO;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImpl implements CollectionService{

    @Autowired
    private CollectionDAO collectionDAO;

	@Override
	public Collection addOrUpdateCardToCollection(Integer idUser, String idCard, Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markCardAsFavourite(Integer idUser, String idCard) {
		// TODO Auto-generated method stub
		
	}

	// deletes a card of a user from his collection
	@Override
	public void removeCardFromCollection(Integer idUser, String idCard) {
		// checks if the collection requested is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findByIdUser(idUser).isEmpty()) {
			throw new IllegalArgumentException("The collection is empty");
		}
		
		// checks if the card is in the collection
		// if it's not, throws an exception
		if (collectionDAO.findByIdUserAndIdCard(idUser, idCard).isEmpty()) {
			throw new IllegalArgumentException("The card is not in the collection");
		}
		
		// deletes the card
		collectionDAO.deleteCard(idUser, idCard);
	}

	
	// gets a list of favourite cards of a certain user
	@Override
	public List<Collection> getFavouriteCards(Integer idUser) throws IllegalArgumentException{
		// checks if the request is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findFavouritesByUserId(idUser).isEmpty()) {
			throw new IllegalArgumentException("Favourites are empty");
		}		
		// calls the method to find all the favourite cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findFavouritesByUserId(idUser);
	}

	// gets a list of all the cards of a certain user
	@Override
	public List<Collection> getUserCollection(Integer idUser) throws IllegalArgumentException{
		// checks if the collection requested is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findByIdUser(idUser).isEmpty()) {
			throw new IllegalArgumentException("The collection is empty");
		}
		// calls the method to find all the cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findByIdUser(idUser);
	}

}