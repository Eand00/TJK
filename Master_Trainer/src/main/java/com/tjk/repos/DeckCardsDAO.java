package com.tjk.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.DeckCards;
import com.tjk.entities.DeckCardsId;

/**
 * The {@code DeckCardsDAO} interface provides methods for accessing and manipulating
 * DeckCards entities in the database.
*/
public interface DeckCardsDAO extends JpaRepository<DeckCards, DeckCardsId> {

	List<DeckCards> findByCard_IdCard(String idUser);

    List<DeckCards> findByDeck_IdDeck(Integer idDeck);

}