package com.tjk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.exceptions.CardNotFoundException;
import com.tjk.repos.CardDAO;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO dao;

    // Retrieves all cards from the database
    @Override
    public List<Card> getAllCards() {
        return dao.findAll();
    }

    // Retrieves cards by name (case insensitive). Throws an exception if the name is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByNameCard(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Card name cannot be null or empty");
        }
        List<Card> cards = dao.findAllByNameCardContaining(name);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with name: " + name);
        }
        return cards;
    }

    // Retrieves a card by its ID. Throws an exception if the ID is null/empty or the card is not found.
    @Override
    public Optional<Card> getCardsByCardId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty");
        }
        return dao.findById(id)
                .or(() -> {
                    throw new CardNotFoundException("Card not found with ID: " + id);
                });
    }

    // Retrieves cards by set name. Throws an exception if the set name is null/empty or no cards are found.
    @Override
    public List<Card> getCardsBySetName(String set) {
        if (set == null || set.trim().isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        List<Card> cards = dao.findBySetName(set);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found for set: " + set);
        }
        return cards;
    }

    // Retrieves cards by series name. Throws an exception if the series name is null/empty or no cards are found.
    @Override
    public List<Card> getCardsBySeries(String series) {
        if (series == null || series.trim().isEmpty()) {
            throw new IllegalArgumentException("Series cannot be null or empty");
        }
        List<Card> cards = dao.findBySeries(series);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found for series: " + series);
        }
        return cards;
    }

    // Retrieves cards by publisher name. Throws an exception if the publisher is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty");
        }
        List<Card> cards = dao.findByPublisher(publisher);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found for publisher: " + publisher);
        }
        return cards;
    }

    // Retrieves cards by generation. Throws an exception if the generation is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByGeneration(String generation) {
        if (generation == null || generation.trim().isEmpty()) {
            throw new IllegalArgumentException("Generation cannot be null or empty");
        }
        List<Card> cards = dao.findByGeneration(generation);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found for generation: " + generation);
        }
        return cards;
    }

    // Retrieves cards by artist name. Throws an exception if the artist name is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByArtist(String artist) {
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be null or empty");
        }
        List<Card> cards = dao.findByArtist(artist);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found for artist: " + artist);
        }
        return cards;
    }

    // Retrieves cards by card type. Throws an exception if the type is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByTypesCard(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        List<Card> cards = dao.findByTypesCardContaining(type);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with type: " + type);
        }
        return cards;
    }

    // Retrieves cards by supertype. Throws an exception if the supertype is null/empty or no cards are found.
    @Override
    public List<Card> getCardsBySupertype(String supertype) {
        if (supertype == null || supertype.trim().isEmpty()) {
            throw new IllegalArgumentException("Supertype cannot be null or empty");
        }
        List<Card> cards = dao.findBySupertype(supertype);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with supertype: " + supertype);
        }
        return cards;
    }

    // Retrieves cards by subtype. Throws an exception if the subtype is null/empty or no cards are found.
    @Override
    public List<Card> getCardsBySubtypes(String subtype) {
        if (subtype == null || subtype.trim().isEmpty()) {
            throw new IllegalArgumentException("Subtype cannot be null or empty");
        }
        List<Card> cards = dao.findBySubtypesContaining(subtype);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with subtype: " + subtype);
        }
        return cards;
    }

    // Retrieves cards by 'evolves from' value. Throws an exception if the value is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByEvolvesFrom(String evolvesFrom) {
        if (evolvesFrom == null || evolvesFrom.trim().isEmpty()) {
            throw new IllegalArgumentException("Evolves From cannot be null or empty");
        }
        List<Card> cards = dao.findByEvolvesFromContaining(evolvesFrom);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found that evolve from: " + evolvesFrom);
        }
        return cards;
    }

    // Retrieves cards by 'evolves to' value. Throws an exception if the value is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByEvolvesTo(String evolvesTo) {
        if (evolvesTo == null || evolvesTo.trim().isEmpty()) {
            throw new IllegalArgumentException("Evolves To cannot be null or empty");
        }
        List<Card> cards = dao.findByEvolvesToContaining(evolvesTo);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found that evolve to: " + evolvesTo);
        }
        return cards;
    }

    // Retrieves cards by rarity. Throws an exception if the rarity is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByRarity(String rarity) {
        if (rarity == null || rarity.trim().isEmpty()) {
            throw new IllegalArgumentException("Rarity cannot be null or empty");
        }
        List<Card> cards = dao.findByRarity(rarity);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with rarity: " + rarity);
        }
        return cards;
    }

    // Retrieves cards by legalities. Throws an exception if the legalities are null/empty or no cards are found.
    @Override
    public List<Card> getCardsByLegalities(String legalities) {
        if (legalities == null || legalities.trim().isEmpty()) {
            throw new IllegalArgumentException("Legalities cannot be null or empty");
        }
        List<Card> cards = dao.findByLegalitiesContaining(legalities);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with legalities: " + legalities);
        }
        return cards;
    }

    // Retrieves cards by regulation mark. Throws an exception if the regulation mark is null/empty or no cards are found.
    @Override
    public List<Card> getCardsByRegulationMark(String regulation) {
        if (regulation == null || regulation.trim().isEmpty()) {
            throw new IllegalArgumentException("Regulation Mark cannot be null or empty");
        }
        List<Card> cards = dao.findByRegulationMarkContaining(regulation);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("No cards found with regulation mark: " + regulation);
        }
        return cards;
    }

    // Filters cards based on multiple attributes (e.g., name, set, series, etc.). It directly interacts with a custom DAO method for filtering.
    @Override
    public List<Card> filterCards(String nameCard, String setName, String series, String publisher, String generation, String artist, String typesCard, String supertype, String subtype, String evolvesFrom, String evolvesTo, String rarity, String legalities, String regulationMark) {
        return dao.findCardsWithFilters(nameCard, setName, series, publisher, generation, artist, typesCard, supertype, subtype, evolvesFrom, evolvesTo, rarity, legalities, regulationMark);
    }
    // Retrieves related cards based on if they evolve from or evolve to the given pokemon name.
	  @Override
	  public List<Card> getRelatedCards(String pokemonName) {
		  return dao.findRelatedCard(pokemonName);
	  }
}