package com.tjk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Deck;
import com.tjk.repos.DeckDAO;

import jakarta.transaction.Transactional;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckDAO dao;

    // Get decks by name
    @Override
    public List<Deck> getDeckByName(String deckName) {
        List<Deck> decks = dao.findByDeckName(deckName);

        if (decks.isEmpty()) {
            throw new IllegalArgumentException("No decks found with the name: " + deckName);
        }

        return decks;
    }

    // Get decks by user ID
    @Override
    public List<Deck> getDecksByIdUser(Integer idUser) {
        List<Deck> decks = dao.findByUser_IdUser(idUser);
        if (!decks.isEmpty()) {
            return decks;
        }
        throw new IllegalArgumentException("User doesn't have any decks");
    }

    // Get public decks
    @Override
    public List<Deck> getPublicDecks() {
        List<Deck> publicDecks = dao.findByIsPrivate(false);
        if (!publicDecks.isEmpty()) {
            return publicDecks;
        }
        throw new IllegalArgumentException("User doesn't have any public decks");
    }

    // Get legal decks
    @Override
    public List<Deck> getLegalDecks() {
        List<Deck> legalDecks = dao.findByLegal(true);
        if (!legalDecks.isEmpty()) {
            return legalDecks;
        }
        throw new IllegalArgumentException("User doesn't have any legal decks");
    }

    // Get deck by ID
    @Override
    public Optional<Deck> getDeckByIdDeck(Integer idDeck) {
        Optional<Deck> deck = dao.findById(idDeck);
        if (deck.isPresent()) {
            return deck;
        }
        throw new IllegalArgumentException("No deck found with id: " + idDeck);
    }

    // Validate deck fields
    @Override
    public boolean isDeckValid(Deck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        if (deck.getDeckName() == null || deck.getDeckName().trim().isEmpty()) {
            throw new IllegalArgumentException("Deck name cannot be null or empty");
        }
        if (deck.getFormat() == null || deck.getFormat().trim().isEmpty()) {
            throw new IllegalArgumentException("Deck format cannot be null or empty");
        }
        if (deck.getLegal() == null) {
            throw new IllegalArgumentException("Legal status must be specified");
        }
        if (deck.getIsPrivate() == null) {
            throw new IllegalArgumentException("Privacy status must be specified");
        }
        if (deck.getUser() == null) {
            throw new IllegalArgumentException("User not found with id: " + deck.getUser().getIdUser());
        }
        if (deck.getCoverCard() == null) {
            throw new IllegalArgumentException("Cover card not found with id: " + deck.getCoverCard().getIdCard());
        }
        return true;
    }

    // Create a new deck
    @Transactional
    @Override
    public Deck createDeck(Deck deck) {
        if (isDeckValid(deck)) {
            return dao.save(deck);
        }
        throw new IllegalArgumentException("Deck could not be created!");
    }

    // Delete deck by ID
    @Override
    public boolean deleteDeck(Integer idDeck) {
        Optional<Deck> deckOptional = dao.findById(idDeck);
        if (deckOptional.isPresent()) {
            dao.delete(deckOptional.get());
            return true;
        } else {
            throw new IllegalArgumentException("Deck with id " + idDeck + " not found.");
        }
    }

    // Update deck by ID
    @Transactional
    @Override
    public Deck updateDeck(Integer idDeck, Deck updatedDeck) {
        Optional<Deck> deckOptional = dao.findById(idDeck);
        if (deckOptional.isPresent()) {
            Deck existingDeck = deckOptional.get();
            if (isDeckValid(updatedDeck)) {
                existingDeck.setDeckName(updatedDeck.getDeckName());
                existingDeck.setFormat(updatedDeck.getFormat());
                existingDeck.setLegal(updatedDeck.getLegal());
                existingDeck.setIsPrivate(updatedDeck.getIsPrivate());
                existingDeck.setUser(updatedDeck.getUser());
                existingDeck.setCoverCard(updatedDeck.getCoverCard());
                return dao.save(existingDeck);
            }
        }
        throw new IllegalArgumentException("Deck with id " + idDeck + " not found.");
    }
}