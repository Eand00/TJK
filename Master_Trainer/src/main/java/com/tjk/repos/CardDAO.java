package com.tjk.repos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tjk.entities.Card;

public interface CardDAO extends JpaRepository<Card, String> {

	// Finds if present a card with a specific id
	Optional<Card> findByIdCard(String id);
	
	// Finds a list of cards in a set
	Optional<Card>  findBySet(String set);
	
	// Finds a list of cards with a specific name
	List<Card> findByName(String name);
	
	// Finds a list of cards with a specific set of types
	Optional<Card> findByTypes(String types);
	
	// Finds a list of cards with a specific set of subtypes
	Optional<Card> findBySubtypes(String subtypes);
	
	// Finds a list of cards with a specific rarity
	Optional<Card> findByRarity(String rarity);
	
}
