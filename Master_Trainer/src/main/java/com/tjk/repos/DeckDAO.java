package com.tjk.repos;



import com.tjk.entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * The {@code DeckDAO} interface provides methods for accessing and manipulating
 * deck entities in the database.
*/
public interface DeckDAO extends JpaRepository<Deck, Integer> {

    /**
     * Finds a deck by its name.
    */
    //Optional<Deck> findByDeckName(String deckName);

    /**
     * Finds all decks owned by a specific user.
    */
    //List<Deck> findByUser(Integer userId);

    /**
     * Finds all decks that are marked as private.
    */
    //List<Deck> findByIsPrivate(boolean privateDeck);

    /**
     * Finds all decks that are legal for tournament play.
    */
    //List<Deck> findByLegal(boolean legal);
}