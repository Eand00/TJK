package com.tjk.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tjk.entities.Card;

/**
 * Repository interface for managing Card entities in the database.
 * Extends JpaRepository to provide standard CRUD operations.
 */
@Repository
public interface CardDAO extends JpaRepository<Card, String>{

	/**
     * Finds all cards with a name that contains the specified string (case-insensitive).
     *
     * @param name the partial or full name of the card to search for.
     * @return a list of cards whose names contain the specified string.
     */
    List<Card> findAllByNameCardContaining(String name);

    /**
     * Finds all cards belonging to the specified set.
     *
     * @param set the name of the card set to search for.
     * @return a list of cards in the specified set.
     */
    List<Card> findBySetName(String set);

    /**
     * Finds all cards belonging to the specified series.
     *
     * @param series the series of the card to search for.
     * @return a list of cards in the specified series.
     */
    List<Card> findBySeries(String series);

    /**
     * Finds all cards from the specified publisher.
     *
     * @param publisher the publisher of the card to search for.
     * @return a list of cards published by the specified publisher.
     */
    List<Card> findByPublisher(String publisher);

    /**
     * Finds all cards from a specific generation.
     *
     * @param generation the generation to search for.
     * @return a list of cards from the specified generation.
     */
    List<Card> findByGeneration(String generation);

    /**
     * Finds all cards drawn by the specified artist.
     *
     * @param artist the artist of the card to search for.
     * @return a list of cards drawn by the specified artist.
     */
    List<Card> findByArtist(String artist);

    /**
     * Finds all cards that contain the specified type.
     *
     * @param type the type of card to search for (e.g., 'Fire', 'Water').
     * @return a list of cards containing the specified type.
     */
    List<Card> findByTypesCardContaining(String type);

    /**
     * Finds all cards belonging to the specified supertype (e.g., 'Pokémon', 'Trainer').
     *
     * @param supertype the supertype of the card to search for.
     * @return a list of cards with the specified supertype.
     */
    List<Card> findBySupertype(String supertype);

    /**
     * Finds all cards containing the specified subtype.
     *
     * @param subtype the subtype of the card to search for.
     * @return a list of cards containing the specified subtype.
     */
    List<Card> findBySubtypesContaining(String subtype);

    /**
     * Finds all cards that evolve from a specific Pokémon.
     *
     * @param evolvesFrom the name of the Pokémon this card evolves from.
     * @return a list of cards that evolve from the specified Pokémon.
     */
    List<Card> findByEvolvesFromContaining(String evolvesFrom);

    /**
     * Finds all cards that evolve into a specific Pokémon.
     *
     * @param evolvesTo the name of the Pokémon this card evolves into.
     * @return a list of cards that evolve into the specified Pokémon.
     */
    List<Card> findByEvolvesToContaining(String evolvesTo);

    /**
     * Finds all cards with a specific rarity level.
     *
     * @param rarity the rarity of the card to search for.
     * @return a list of cards with the specified rarity.
     */
    List<Card> findByRarity(String rarity);

    /**
     * Finds all cards with specific legalities.
     *
     * @param legalities the legalities associated with the card.
     * @return a list of cards with the specified legalities.
     */
    List<Card> findByLegalitiesContaining(String legalities);

    /**
     * Finds all cards containing the specified regulation mark.
     *
     * @param regulation the regulation mark to search for.
     * @return a list of cards with the specified regulation mark.
     */
    List<Card> findByRegulationMarkContaining(String regulation);

    /**
     * Finds cards based on a combination of filters such as name, set, series, artist, etc.
     * Each filter is optional, and only non-null filters will be applied.
     *
     * @param nameCard the name of the card to search for (optional).
     * @param setName the set name of the card (optional).
     * @param series the series the card belongs to (optional).
     * @param publisher the publisher of the card (optional).
     * @param generation the generation of the card (optional).
     * @param artist the artist who drew the card (optional).
     * @param typesCard the types of the card (optional).
     * @param supertype the supertype of the card (optional).
     * @param subtypes the subtypes of the card (optional).
     * @param evolvesFrom the name of the Pokémon this card evolves from (optional).
     * @param evolvesTo the name of the Pokémon this card evolves into (optional).
     * @param rarity the rarity of the card (optional).
     * @param legalities the legalities of the card (optional).
     * @param regulationMark the regulation mark of the card (optional).
     * @return a list of cards matching the specified filters.
     */
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

    /**
     * Finds cards related to a specific Pokémon, either by evolving from or evolving into it.
     *
     * @param pokemonName the name of the Pokémon to search for in the evolvesFrom or evolvesTo fields.
     * @return a list of cards that evolve from or evolve into the specified Pokémon.
     */
    @Query("SELECT c from Card c WHERE "
            + "c.evolvesFrom LIKE CONCAT('%', :pokemonName, '%') OR "
            + "c.evolvesTo LIKE CONCAT('%', :pokemonName, '%')")
    List<Card> findRelatedCard(@Param("pokemonName") String pokemonName);
    
}