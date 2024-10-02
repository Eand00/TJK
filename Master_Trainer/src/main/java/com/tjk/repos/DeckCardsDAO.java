package com.tjk.repos;



import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * The {@code DeckCardsDAO} interface provides methods for accessing and manipulating
 * DeckCards entities in the database.
*/
public interface DeckCardsDAO extends JpaRepository<DeckCards, DeckCardsId> {

    /**
     * Finds a list of cards in the deck by the ID of the deck.
    */
    //List<DeckCards> findAllCardsByDeckName(String deckName);

    /**
     * Finds a list of decks that use a card by the ID of the card.
    */
    //List<DeckCards> findAllDeckByCardName(String cardName);

    /**
     * find how many copies of a card are in a specific deck by the ID of the card and the ID of the deck.
    */
    //List<DeckCards> findAllByDeckNameAndCardName(String deckName, String cardName);
}