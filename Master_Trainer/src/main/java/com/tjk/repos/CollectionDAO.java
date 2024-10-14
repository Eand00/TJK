package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {

	// Searches a certain card in the collection of a user
	Optional<Collection> findByUser_IdUserAndCard_IdCard(Integer idUser, String idCard);

    // Finds a list of cards in owned by a user.
    List<Collection> findByUser_IdUser(Integer idUser);

    // List of Collection of Favourite cards that belong to a certain user, given his idUser
    List<Collection> findByUser_IdUserAndFavourite(Integer idUser, boolean favourite);

    // Deletes a certain card from the collection of a user
    void deleteByUser_IdUserAndCard_IdCard(Integer idUser, String idCard);

}
