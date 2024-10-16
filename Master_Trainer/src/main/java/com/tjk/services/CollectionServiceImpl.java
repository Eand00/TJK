package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;
import com.tjk.entities.User;
import com.tjk.exceptions.CardNotFoundException;
import com.tjk.exceptions.UserNotFoundException;
import com.tjk.exceptions.EmptyCollectionException;
import com.tjk.repos.CardDAO;
import com.tjk.repos.CollectionDAO;
import com.tjk.repos.UserDAO;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionDAO collectionDAO;

    @Autowired
    private CardDAO cardDAO;

    @Autowired
    private UserDAO userDAO; 

    // Retrieves all collection records
    public List<Collection> getAll() {
        return collectionDAO.findAll();
    }

    // Finds a collection entry by user ID and card ID
    @Override
    public Collection findByUserAndByCard(Integer idUser, String idCard) {
        return collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
                .orElseThrow(() -> new CardNotFoundException("Card not found for the user"));
    }

    // Adds a card to a user's collection, or increments the quantity if it already exists
    @Override
    public Collection addCardToCollection(Integer idUser, String idCard, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        // Check if card exists in user's collection, if not create a new entry
        Collection collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
                .orElseGet(() -> {
                    Card card = cardDAO.findById(idCard)
                            .orElseThrow(() -> new CardNotFoundException("Card not found with ID: " + idCard));
                    User user = userDAO.findById(idUser)
                            .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + idUser));
                    
                    // Create a new collection entry
                    Collection newCollection = new Collection();
                    newCollection.setId(new CollectionId(idCard, idUser));
                    newCollection.setCard(card);
                    newCollection.setUser(user);
                    newCollection.setFavourite(false);
                    newCollection.setQuantity(quantity > 0 ? quantity : 1);
                    return newCollection;
                });

        // Update quantity if card already exists in collection
        collection.setQuantity(collection.getQuantity() + quantity);
        return collectionDAO.save(collection);
    }

    // Updates the quantity of a card in the user's collection
    @Override
    public Collection updateCardQuantity(Integer idUser, String idCard, Integer newQuantity) {
        Collection collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
                .orElseThrow(() -> new CardNotFoundException("Card not found for the user"));
        
        // Set new quantity or default to 1 if new quantity is invalid
        collection.setQuantity(newQuantity > 0 ? newQuantity : 1);
        return collectionDAO.save(collection);
    }

    // Marks or unmarks a card as a favourite in the user's collection
    @Override
    public Collection markCardAsFavourite(Integer idUser, String idCard) {
        Collection collection = collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard)
                .orElseThrow(() -> new CardNotFoundException("The card is not in the collection"));

        // Toggle the favourite status
        collection.setFavourite(!collection.getFavourite());
        return collectionDAO.save(collection);
    }

    // Removes a card from the user's collection
    @Override
    @Transactional
    public boolean removeCardFromCollection(Integer idUser, String idCard) {
        if (collectionDAO.findByUser_IdUserAndCard_IdCard(idUser, idCard).isEmpty()) {
            return false;
        }
        collectionDAO.deleteByUser_IdUserAndCard_IdCard(idUser, idCard);
        return true;
    }

    // Retrieves all favourite cards from the user's collection
    @Override
    public List<Collection> getFavouriteCards(Integer idUser) {
        List<Collection> favourites = collectionDAO.findByUser_IdUserAndFavourite(idUser, true);
        if (favourites.isEmpty()) {
            throw new EmptyCollectionException("No favourite cards found for the user");
        }
        return favourites;
    }

    // Retrieves the entire collection of a user
    @Override
    public List<Collection> getUserCollection(Integer idUser) {
        List<Collection> collections = collectionDAO.findByUser_IdUser(idUser);
        if (collections.isEmpty()) {
            throw new EmptyCollectionException("The collection is empty");
        }
        return collections;
    }
}
