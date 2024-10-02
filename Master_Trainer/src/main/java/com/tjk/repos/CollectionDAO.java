package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {
	
	// Finds if present a Collection using the ids of the user and the card 
	//Optional<Collection> findAllByIdUserAndIdCard(Integer idUser, String idCard);
	
    // Finds a list of cards in owned by a user.
    //List<Collection> findByIdUser(Integer idUser);

    // Finds a list of users that own a card by the ID of the card.
    //List<Collection> findAllUserByCardName(String cardName);

    // Finds a list of cards with a specific cardName owned by a user.
    //List<Collection> findAllByIdUserAndCardName(Integer idUser, String cardName);

}
