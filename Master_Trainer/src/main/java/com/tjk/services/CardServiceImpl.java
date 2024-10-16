package com.tjk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.repos.CardDAO;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO dao;

	@Override
	public List<Card> getAllCards() {
		return dao.findAll();
	}

	@Override
	public List<Card> getCardsByNameCard(String name) {
		return dao.findAllByNameCardContaining(name);
	}

	@Override
	public Optional<Card> getCardsByCardId(String id) {
		return dao.findById(id);
	}

	@Override
	public List<Card> getCardsBySetName(String set) {
		return dao.findBySetName(set);
	}

	@Override
	public List<Card> getCardsBySeries(String series) {
		return dao.findBySeries(series);
	}

	@Override
	public List<Card> getCardsByPublisher(String publisher) {
		return dao.findByPublisher(publisher);
	}

	@Override
	public List<Card> getCardsByGeneration(String generation) {
		return dao.findByGeneration(generation);
	}

	@Override
	public List<Card> getCardsByArtist(String artist) {
		return dao.findByArtist(artist);
	}

	@Override
	public List<Card> getCardsByTypesCard(String type) {
		return dao.findByTypesCardContaining(type);
	}

	@Override
	public List<Card> getCardsBySupertype(String supertype) {
		return dao.findBySupertype(supertype);
	}

	@Override
	public List<Card> getCardsBySubtypes(String subtype) {
		return dao.findBySubtypesContaining(subtype);
	}

	@Override
	public List<Card> getCardsByEvolvesFrom(String evolvesFrom) {
		return dao.findByEvolvesFromContaining(evolvesFrom);
	}

	@Override
	public List<Card> getCardsByEvolvesTo(String evolvesTo) {
		return dao.findByEvolvesToContaining(evolvesTo);
	}

	@Override
	public List<Card> getCardsByRarity(String rarity) {
		return dao.findByRarity(rarity);
	}

	@Override
	public List<Card> getCardsByLegalities(String legalities) {
		return dao.findByLegalitiesContaining(legalities);
	}

	@Override
	public List<Card> getCardsByRegulationMark(String regulation) {
		return dao.findByRegulationMarkContaining(regulation);
	}
	@Override
    public List<Card> filterCards(String nameCard, String setName, String series, String publisher, String generation, String artist, String typesCard, String supertype, String subtype,  String evolvesFrom, String evolvesTo, String rarity, String legalities, String regulationMark) {
        return dao.findCardsWithFilters(nameCard, setName, series, publisher, generation, artist, typesCard, supertype, subtype,  evolvesFrom, evolvesTo, rarity, legalities, regulationMark);
    }

	@Override
	public List<Card> getRelatedCards(String pokemon) {
		return dao.findRelatedCard(pokemon);
	}
}