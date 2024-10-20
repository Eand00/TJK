package com.tjk.services;

import java.util.List;
import java.util.Optional;

import com.tjk.entities.Card;

/**
 * The {@code CardService} interface provides methods for retrieving and filtering Card entities.
 * It defines a variety of methods for retrieving cards based on different attributes and complex filtering.
 */
public interface CardService {

    /**
     * Retrieves all available cards.
     *
     * @return a list of all Card objects.
     */
    public List<Card> getAllCards();

    /**
     * Retrieves cards that contain the given name or part of the name.
     *
     * @param name the name or part of the card name to search for.
     * @return a list of Card objects that match the given name.
     */
    public List<Card> getCardsByNameCard(String name);

    /**
     * Retrieves a card by its unique ID.
     *
     * @param id the unique ID of the card.
     * @return an Optional containing the Card if found, or an empty Optional if not found.
     */
    public Optional<Card> getCardsByCardId(String id);

    /**
     * Retrieves cards that belong to a specific set.
     *
     * @param set the name of the set to search for.
     * @return a list of Card objects that belong to the specified set.
     */
    public List<Card> getCardsBySetName(String set);

    /**
     * Retrieves cards that belong to a specific series.
     *
     * @param series the series name to search for.
     * @return a list of Card objects that match the given series.
     */
    public List<Card> getCardsBySeries(String series);

    /**
     * Retrieves cards published by a specific publisher.
     *
     * @param publisher the name of the publisher.
     * @return a list of Card objects that match the given publisher.
     */
    public List<Card> getCardsByPublisher(String publisher);

    /**
     * Retrieves cards that belong to a specific generation.
     *
     * @param generation the generation name or number.
     * @return a list of Card objects that match the given generation.
     */
    public List<Card> getCardsByGeneration(String generation);

    /**
     * Retrieves cards created by a specific artist.
     *
     * @param artist the artist's name to search for.
     * @return a list of Card objects that match the given artist.
     */
    public List<Card> getCardsByArtist(String artist);

    /**
     * Retrieves cards that belong to a specific type or contain the given type in their description.
     *
     * @param type the type of card to search for.
     * @return a list of Card objects that match the given type.
     */
    public List<Card> getCardsByTypesCard(String type);

    /**
     * Retrieves cards that belong to a specific supertype.
     *
     * @param supertype the supertype of the card.
     * @return a list of Card objects that match the given supertype.
     */
    public List<Card> getCardsBySupertype(String supertype);

    /**
     * Retrieves cards that belong to a specific subtype or contain the given subtype in their description.
     *
     * @param subtype the subtype of the card.
     * @return a list of Card objects that match the given subtype.
     */
    public List<Card> getCardsBySubtypes(String subtype);

    /**
     * Retrieves cards that evolve from a specific card.
     *
     * @param evolvesFrom the name or ID of the card that the result cards evolve from.
     * @return a list of Card objects that evolve from the specified card.
     */
    public List<Card> getCardsByEvolvesFrom(String evolvesFrom);

    /**
     * Retrieves cards that evolve into a specific card.
     *
     * @param evolvesTo the name or ID of the card that the result cards evolve to.
     * @return a list of Card objects that evolve to the specified card.
     */
    public List<Card> getCardsByEvolvesTo(String evolvesTo);

    /**
     * Retrieves cards that have a specific rarity.
     *
     * @param rarity the rarity of the card.
     * @return a list of Card objects that match the given rarity.
     */
    public List<Card> getCardsByRarity(String rarity);

    /**
     * Retrieves cards that match specific legalities.
     *
     * @param legalities the legalities of the card to search for.
     * @return a list of Card objects that match the given legalities.
     */
    public List<Card> getCardsByLegalities(String legalities);

    /**
     * Retrieves cards by their regulation mark.
     *
     * @param regulation the regulation mark to search for.
     * @return a list of Card objects that match the given regulation mark.
     */
    public List<Card> getCardsByRegulationMark(String regulation);

    /**
     * Filters cards based on various attributes.
     * This method allows for complex filtering by combining multiple card attributes.
     *
     * @param nameCard the name of the card.
     * @param setName the set name of the card.
     * @param series the series the card belongs to.
     * @param publisher the publisher of the card.
     * @param generation the generation the card belongs to.
     * @param artist the artist who created the card.
     * @param typesCard the type of the card.
     * @param supertype the supertype of the card.
     * @param subtype the subtype of the card.
     * @param evolvesFrom the name of the card it evolves from.
     * @param evolvesTo the name of the card it evolves into.
     * @param rarity the rarity of the card.
     * @param legalities the legalities of the card.
     * @param regulationMark the regulation mark of the card.
     * @return a list of Card objects that match the specified filters.
     */
    public List<Card> filterCards(String nameCard, String setName, String series, String publisher, String generation, String artist, String typesCard, String supertype, String subtype, String evolvesFrom, String evolvesTo, String rarity, String legalities, String regulationMark);

    /**
     * Retrieves related cards based on a Pokémon's name.
     * This method finds cards that either evolve from or evolve into the specified Pokémon.
     *
     * @param pokemonName the name of the Pokémon to search for related cards.
     * @return a list of related Card objects.
     */
    public List<Card> getRelatedCards(String pokemonName);
}