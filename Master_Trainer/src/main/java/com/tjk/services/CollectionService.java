package com.tjk.services;

import java.util.List;

import com.tjk.entities.Collection;

public interface CollectionService {

    /**
     * Adds a card to the user's collection or updates the quantity if it already exists.
     *
     * @param idUser the ID of the user
     * @param idCard the ID of the card
     * @param quantity the quantity of the card to add
     * @return the updated or newly created Collection entry
     */
    public Collection addCardToCollection(Integer idUser, String idCard, Integer quantity);

    /**
     * Updates the quantity of a card in the user's collection or adds it if it doesn't exist.
     *
     * @param idUser the ID of the user
     * @param idCard the ID of the card
     * @param newQuantity the new quantity to set for the card
     * @return the updated Collection entry
     */
    public Collection updateCardQuantity(Integer idUser, String idCard, Integer newQuantity);

    /**
     * Removes a card from the user's collection if it exists.
     *
     * @param idUser the ID of the user
     * @param idCard the ID of the card
     * @return true if the card was successfully removed, false otherwise
     */
    public boolean removeCardFromCollection(Integer idUser, String idCard);

    /**
     * Marks a card in the user's collection as a favourite.
     *
     * @param idUser the ID of the user
     * @param idCard the ID of the card
     * @return the updated Collection entry with the card marked as a favourite
     */
    public Collection markCardAsFavourite(Integer idUser, String idCard);

    /**
     * Retrieves all favourite cards in the user's collection.
     *
     * @param idUser the ID of the user
     * @return a list of Collection entries representing the user's favourite cards
     */
    public List<Collection> getFavouriteCards(Integer idUser);

    /**
     * Retrieves all cards in the user's collection.
     *
     * @param idUser the ID of the user
     * @return a list of Collection entries representing the user's entire collection
     */
    public List<Collection> getUserCollection(Integer idUser);

    /**
     * Retrieves a specific card in the user's collection by user ID and card ID.
     *
     * @param idUser the ID of the user
     * @param idCard the ID of the card
     * @return the Collection entry representing the card in the user's collection
     */
    public Collection findByUserAndByCard(Integer idUser, String idCard);
}

