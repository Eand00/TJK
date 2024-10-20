package com.tjk.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.Deck;
/**
 * The {@code DeckDAO} interface provides methods for accessing and manipulating
 * Deck entities in the database.
 * Extends JpaRepository to provide CRUD operations for Deck entities.
 */
public interface DeckDAO extends JpaRepository<Deck, Integer> {

    /**
     * Finds all decks with a specific name.
     * This method is useful for searching decks by their exact name.
     *
     * @param deckName the name of the deck to search for.
     * @return a list of Deck objects that match the provided deck name.
     */
    List<Deck> findByDeckName(String deckName);

    /**
     * Finds all decks that are owned by a specific user.
     * This method is useful for retrieving all decks created by a user, identified by their user ID.
     *
     * @param idUser the ID of the user who owns the decks.
     * @return a list of Deck objects that belong to the specified user.
     */
    List<Deck> findByUser_IdUser(Integer idUser);

    /**
     * Finds all decks that are marked as private.
     * This method is useful for filtering out decks that are private or public.
     *
     * @param isPrivate a boolean value indicating whether to search for private decks.
     * @return a list of Deck objects that are marked as private or public based on the parameter.
     */
    List<Deck> findByIsPrivate(boolean isPrivate);

    /**
     * Finds all decks that are legal for tournament play.
     * This method is useful for retrieving only decks that meet the legality requirements for official tournaments.
     *
     * @param legal a boolean indicating whether the deck is legal for tournament play.
     * @return a list of Deck objects that are legal or illegal based on the parameter.
     */
    List<Deck> findByLegal(boolean legal);
}