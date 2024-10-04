package com.tjk.services;

import java.util.List;
import java.util.Optional;

import com.tjk.entities.Card;

public interface CardService {

	public List<Card> getAllCards();
	
	public Optional<Card> getCardsByName(String name);
	public Optional<Card> getCardsByCardId(String id);
	public Optional<Card> getCardsBySet(String set);
	public Optional<Card> getCardsBySeries(String series);
	public Optional<Card> getCardsByPublisher(String publisher);
	public Optional<Card> getCardsByGeneration(String generation);
	public Optional<Card> getCardsByArtist(String artist);
	public Optional<Card> getCardsByType(String type);
	public Optional<Card> getCardsBySupertype(String supertype);
	public Optional<Card> getCardsBySubtype(String subtype);
	public Optional<Card> getCardsByEvolvesFrom(String evolvesFrom);
	public Optional<Card> getCardsByEvolvesTo(String evolvesTo);
	public Optional<Card> getCardsByRarity(String rarity);
	public Optional<Card> getCardsByLegalities(String legalities);
	public Optional<Card> getCardsByRegulation(String regulation);
	
	//Need to be turned into a dynamic querry or use functional programming.

}