package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Card;
import com.tjk.repos.CardDAO;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardDAO cardRepository;

    // Retrieves all cards from the database
    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    
    @Override
    public Optional<Card> getCardsByName(String name) {
        return cardRepository.findByName(name);
    }

	@Override
	public Optional<Card> getCardsByCardId(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsBySet(String set) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsBySeries(String series) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByGeneration(String generation) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByArtist(String artist) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByType(String type) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsBySupertype(String supertype) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsBySubtype(String subtype) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByEvolvesFrom(String evolvesFrom) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByEvolvesTo(String evolvesTo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByRarity(String rarity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByLegalities(String legalities) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Card> getCardsByRegulation(String regulation) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}