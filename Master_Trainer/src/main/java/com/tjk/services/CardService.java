package com.tjk.services;

import java.util.List;
import java.util.Optional;

import com.tjk.entities.Card;

public interface CardService {

	public List<Card> getAllCards();
	
    public List<Card> getCardsByNameCard(String name);
    public Optional<Card> getCardsByCardId(String id);
    public List<Card> getCardsBySetName(String set);
    public List<Card> getCardsBySeries(String series);
    public List<Card> getCardsByPublisher(String publisher);
    public List<Card> getCardsByGeneration(String generation);
    public List<Card> getCardsByArtist(String artist);
    public List<Card> getCardsByTypesCard(String type);
    public List<Card> getCardsBySupertype(String supertype);
    public List<Card> getCardsBySubtypes(String subtype);
    public List<Card> getCardsByEvolvesFrom(String evolvesFrom);
    public List<Card> getCardsByEvolvesTo(String evolvesTo);
    public List<Card> getCardsByRarity(String rarity);
    public List<Card> getCardsByLegalities(String legalities);
    public List<Card> getCardsByRegulationMark(String regulation);
	
    public List<Card> filterCards(String nameCard, String setName, String series, String publisher, String generation, String artist, String typesCard, String supertype, String subtype,  String evolvesFrom, String evolvesTo, String rarity, String legalities, String regulationMark);
}