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
	public Collection addOrUpdateCardToCollection(Integer userId, String cardId, Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markCardAsFavourite(Integer userId, String cardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCardFromCollection(Integer userId, String cardId) {
		// TODO Auto-generated method stub
		
	}

	
	// gets a list of favourite cards of a certain user
	@Override
	public List<Collection> getFavouriteCards(Integer userId) throws IllegalArgumentException{
		// checks if the request is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findFavouriteByUserId(userId).isEmpty()) {
			throw new IllegalArgumentException("Favourites are empty");
		}		
		// calls the method to find all the favourite cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findFavouriteByUserId(userId);
	}

	@Override
	public List<Collection> getUserCollection(Integer userId) throws IllegalArgumentException{
		// checks if the collection requested is empty or not
		// if it's empty, throws an exception
		if (collectionDAO.findByIdUser(userId).isEmpty()) {
			throw new IllegalArgumentException("The collection is empty");
		}
		// calls the method to find all the cards of the collection by the idUser
		// returns the values received
		return collectionDAO.findByIdUser(userId);
	}

}