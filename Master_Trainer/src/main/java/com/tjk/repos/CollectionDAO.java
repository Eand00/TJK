package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

/**
 * Repository interface for managing Collection entities in the database.
 * Extends JpaRepository to provide standard CRUD operations for Collection with a composite key (CollectionId).
 */
public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {

    /**
     * Searches for a specific card in a user's collection by matching both the user ID and the card ID.
     *
     * @param idUser the ID of the user who owns the collection.
     * @param idCard the ID of the card being searched in the collection.
     * @return an Optional containing the Collection if found, or empty if not found.
     */
    Optional<Collection> findByUser_IdUserAndCard_IdCard(Integer idUser, String idCard);

    /**
     * Retrieves all collections (cards) owned by a specific user.
     *
     * @param idUser the ID of the user whose collection is being searched.
     * @return a list of Collection objects that belong to the specified user.
     */
    List<Collection> findByUser_IdUser(Integer idUser);

    /**
     * Retrieves a list of favourite cards in the collection of a specific user.
     *
     * @param idUser the ID of the user whose favourite cards are being searched.
     * @param favourite a boolean indicating whether the card is marked as a favourite.
     * @return a list of Collection objects marked as favourite that belong to the specified user.
     */
    List<Collection> findByUser_IdUserAndFavourite(Integer idUser, boolean favourite);

    /**
     * Deletes a specific card from a user's collection by matching both the user ID and the card ID.
     *
     * @param idUser the ID of the user who owns the collection.
     * @param idCard the ID of the card to be deleted from the collection.
     */
    void deleteByUser_IdUserAndCard_IdCard(Integer idUser, String idCard);

}