package com.tjk.services;

import java.util.List;

import com.tjk.entities.Collection;

public interface CollectionService {

	public Collection addCardToCollection(Integer idUser, String idCard, Integer quantity); // checks if card already in collection if it is adds quantity else add to collection
	public void updateCardQuantity(Integer idUser, String idCard, Integer newQuantity); // checks if card already in collection if is updates quantity else add to collection
	public boolean removeCardFromCollection(Integer idUser, String idCard); // checks if card already in collection, if it is removes it
	public Collection markCardAsFavourite(Integer idUser, String idCard);// checks if card already in collection, if it is marks it as a favourite
	public List<Collection> getFavouriteCards(Integer idUser); // get all the favourite cards in the collection
	public List<Collection> getUserCollection(Integer idUser); // get all the cards in the collection
}

