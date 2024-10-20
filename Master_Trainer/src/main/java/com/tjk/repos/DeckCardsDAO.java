package com.tjk.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;

/**
 * The {@code DeckCardsDAO} interface provides methods for accessing and manipulating
 * DeckCards entities in the database.
 * Extends JpaRepository to provide CRUD operations for DeckCards, which is identified by a composite key (DeckCardsId).
 */
public interface DeckCardsDAO extends JpaRepository<DeckCards, DeckCardsId> {

    /**
     * Retrieves all DeckCards entries where the associated card ID matches the provided card ID.
     * This method is useful for finding all decks that contain a specific card.
     *
     * @param idCard the ID of the card being searched in DeckCards entities.
     * @return a list of DeckCards objects that include the specified card ID.
     */
    List<DeckCards> findByCard_IdCard(String idCard);

    /**
     * Retrieves all DeckCards entries where the associated deck ID matches the provided deck ID.
     * This method is useful for finding all cards in a specific deck.
     *
     * @param idDeck the ID of the deck being searched in DeckCards entities.
     * @return a list of DeckCards objects that belong to the specified deck ID.
     */
    List<DeckCards> findByDeck_IdDeck(Integer idDeck);
}