package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Collection;
import com.tjk.repos.CollectionDAO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> getUserCollection(Integer userId) {
		// get all the cards of the user and returns them as a list
		return collectionDAO.findByIdUser(userId);
	}

}