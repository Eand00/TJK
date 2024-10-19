package com.tjk.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tjk.entities.Card;

@Repository
public interface CardDAO extends JpaRepository<Card, String>{

	List<Card> findAllByNameCardContaining(String name);

	List<Card> findBySetName(String set);

	List<Card> findBySeries(String series);

	List<Card> findByPublisher(String publisher);

	List<Card> findByGeneration(String generation);

	List<Card> findByArtist(String artist);

	List<Card> findByTypesCardContaining(String type);

	List<Card> findBySupertype(String supertype);

	List<Card> findBySubtypesContaining(String subtype);

	List<Card> findByEvolvesFromContaining(String evolvesFrom);

	List<Card> findByEvolvesToContaining(String evolvesTo);

	List<Card> findByRarity(String rarity);

	List<Card> findByLegalitiesContaining(String legalities);

	List<Card> findByRegulationMarkContaining(String regulation);

	@Query("SELECT c FROM Card c WHERE " +
            "(:nameCard IS NULL OR c.nameCard LIKE CONCAT('%', :nameCard, '%')) AND " +
            "(:setName IS NULL OR c.setName = :setName) AND " +
            "(:series IS NULL OR c.series = :series) AND " +
            "(:publisher IS NULL OR c.publisher = :publisher) AND " +
            "(:generation IS NULL OR c.generation = :generation) AND " +
            "(:artist IS NULL OR c.artist = :artist) AND " +
            "(:typesCard IS NULL OR c.typesCard LIKE CONCAT('%', :typesCard, '%')) AND " +
            "(:supertype IS NULL OR c.supertype = :supertype) AND " +
            "(:subtypes IS NULL OR c.subtypes LIKE CONCAT('%', :subtypes, '%')) AND " +
            "(:evolvesFrom IS NULL OR c.evolvesFrom LIKE CONCAT('%', :evolvesFrom, '%')) AND " +
            "(:evolvesTo IS NULL OR c.evolvesTo LIKE CONCAT('%', :evolvesTo, '%')) AND " +
            "(:rarity IS NULL OR c.rarity = :rarity) AND " +
            "(:legalities IS NULL OR c.legalities LIKE CONCAT('%', :legalities, '%')) AND " +
            "(:regulationMark IS NULL OR c.regulationMark LIKE CONCAT('%', :regulationMark, '%'))")
     List<Card> findCardsWithFilters(
             @Param("nameCard") String nameCard,
             @Param("setName") String setName,
             @Param("series") String series,
             @Param("publisher") String publisher,
             @Param("generation") String generation,
             @Param("artist") String artist,
             @Param("typesCard") String typesCard,
             @Param("supertype") String supertype,
             @Param("subtypes") String subtypes,
             @Param("evolvesFrom") String evolvesFrom,
             @Param("evolvesTo") String evolvesTo,
             @Param("rarity") String rarity,
             @Param("legalities") String legalities,
             @Param("regulationMark") String regulationMark);

	@Query("SELECT c from Card c WHERE "
			+ "c.evolvesFrom LIKE CONCAT('%', :pokemonName, '%') OR "
			+ "c.evolvesTo LIKE CONCAT('%', :pokemonName, '%')")
	List<Card> findRelatedCard(@Param("pokemonName") String pokemonName);

}