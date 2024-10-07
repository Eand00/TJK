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

	@Override
	public List<Collection> getFavouriteCards(Integer userId) {
		// gets the collection of the user
		List<Collection> userCollection = getUserCollection(userId);
		
		Iterator<Collection> iterator = userCollection.iterator();
		// cicles the collection of the user to check if a card is tagged as favourite or not
		// if it's not favourite, removes it from the list
		while (iterator.hasNext()) {
			Collection collection = iterator.next();
			if (collection.getFavourite() == false) {
				iterator.remove();
			}
		}
		// returns the result
		return userCollection;
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