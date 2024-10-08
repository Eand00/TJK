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

	List<DeckCards> findByCard_Id(String idUser);
	
    List<DeckCards> findByDeck_Id(Integer idDeck);

}