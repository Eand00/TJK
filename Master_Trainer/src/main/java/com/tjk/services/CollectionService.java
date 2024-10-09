package com.tjk.services;

import java.util.List;

import com.tjk.entities.Collection;

public interface CollectionService {

	public void addOrUpdateCardToCollection(Integer userId, String cardId, Integer quantity);//check if card already in collection if is update quntity else add to collection
	public void markCardAsFavourite(Integer userId, String cardId);// if card not in collection throw new RuntimeException("Card not found in collection")
	public void removeCardFromCollection(Integer userId, String cardId);
	public List<Collection> getFavouriteCards(Integer userId);
	public List<Collection> getUserCollection(Integer userId);
}
