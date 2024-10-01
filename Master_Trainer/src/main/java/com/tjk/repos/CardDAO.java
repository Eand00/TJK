package com.tjk.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tjk.entities.Card;

public interface CardDAO extends JpaRepository<Card, String> {
	
	/**
     * find the card by is Id.
    */
	Optional<Card> findByIdCard(String CardId);
	
	/**
     * find the card by is name.
    */
	Optional<Card> findByCardName(String cardName);
	
	/**
     * find the card by is type.
    */
	Optional<Card> findByCardType(String cardType);
	
	/**
     * find the card by is set.
    */
	Optional<Card> findByCardSet(String cardSet);
	
	/**
     * find the card by is serie.
    */
	Optional<Card> findByCardSerie(String cardSerie);
	
	/**
     * find the card by is publisher.
    */
	Optional<Card> findByCardPublisher(String cardPublisher);
	
	/**
     * find the card by is generation.
    */
	Optional<Card> findByCardGeneration(String cardGeneration);
	
	/**
     * find the card by is release.
    */
	Optional<Card> findByCardReleaseDate(String cardRelease);
	
	/**
     * find the card by is artist.
    */
	Optional<Card> findByCardArtist(String cardArtist);
	
	/**
     * find the card by is super type.
    */
	Optional<Card> findByCardSuperType(String cardSuperType);
	
	/**
     * find the card by is sub type.
    */
	Optional<Card> findByCardSubType(String cardSubType);
	
	/**
     * find the card by is hp.
    */
	Optional<Card> findByCardHp(String cardHp);
	
	/**
     * find the card by is level.
    */
	Optional<Card> findByCardlevel(String cardLevel);
	
	/**
     * find the card by is evolution up.
    */
	Optional<Card> findByCardEvolveTo(String cardEvolvesTo);
	
	/**
     * find the card by is evolution down.
    */
	Optional<Card> findByCardEvolveFrom(String cardEvolvesFrom);
	
	/**
     * find the card by is abilities.
    */
	Optional<Card> findByCardAbilities(String cardAbilities);
	
	/**
     * find the card by is abilities.
    */
	Optional<Card> findByCardAttak(String cardAttak);
	
	/**
     * find the card by is weakness.
    */
	Optional<Card> findByCardWeakness(String cardWeakness);
	
	/**
     * find the card by is abilities.
    */
	Optional<Card> findByCardRetreatCost(String cardRetreatCost);
	
	/**
     * find the card by is converted cost.
    */
	Optional<Card> findByCardConvertedCost(String cardConvertedCost);
	
	/**
     * find the card by is rarity.
    */
	Optional<Card> findByCardRarity(String cardRarity);
	
	/**
     * find the card by is NationalPokedexNumber.
    */
	Optional<Card> findByCardNationalPokedexNumber(String NationalPokedexNumber);
	
	/**
     * find the card by is legalities.
    */
	Optional<Card> findByCardLegalities(String cardLegalities);
	
	/**
     * find the card by is resistances.
    */
	Optional<Card> findByCardResistance(String cardResistance);
	
	/**
     * find the card by is rules.
    */
	Optional<Card> findByCardRules(String cardRules);
	
	/**
     * find the card by is regulation mark.
    */
	Optional<Card> findByCardRegulationMark(String cardRegulationMark);
	
	/**
     * find the card by is ancient trait.
    */
	Optional<Card> findByAncientTrait(String cardAncientTrait);
}
