package com.tjk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Deck;
import com.tjk.repos.DeckDAO;
import java.util.Optional;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckDAO deckRepository;

    @Override
    public Optional<Deck> getDeckByName(String deckName) {
        return deckRepository.findByDeckName(deckName);
    }

    @Override
    public Optional<Deck> getDeckByIdUser(Integer idUser) {
        List<Deck> decks = deckRepository.findByUserIdUser(idUser);
        if (!decks.isEmpty()) {
            return Optional.of(decks.get(0));
        }
        throw new IllegalArgumentException("User doesn't have any decks");
    }

    @Override
    public Optional<Deck> getPublicDecks() {
        List<Deck> publicDecks = deckRepository.findByIsPrivate(false);
        if (!publicDecks.isEmpty()) {
            return Optional.of(publicDecks.get(0));
        }
        throw new IllegalArgumentException("User doesn't have any public decks");
    }

    @Override
    public Optional<Deck> getLegalDecks() {
        List<Deck> legalDecks = deckRepository.findByIsLegal(true);
        if (!legalDecks.isEmpty()) {
            return Optional.of(legalDecks.get(0));
        }
        throw new IllegalArgumentException("User doesn't have any legal decks");
    }

    @Override
    public Optional<Deck> getDeckByIdDeck(Integer idDeck) {
        return deckRepository.findById(idDeck);
    }

    @Override
    public boolean isDeckValid(Integer deckId) {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        return deckOptional.isPresent() && deckOptional.get().isLegal();
    }
    
    private void validateDeckCommonFields(Deck deck) {
        if (deck.getDeckName() == null || deck.getDeckName().isEmpty()) {
            throw new IllegalArgumentException("Deck name cannot be null or empty");
        }
        if (deck.getFormat() == null || deck.getFormat().isEmpty()) {
            throw new IllegalArgumentException("Format cannot be null or empty");
        }
        if (deck.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (deck.getDeckCards() == null) {
            // to finish
        	// throw new IllegalArgumentException("Cover card cannot be null");
        }
    }

    @Override
    public Deck createDeck(Deck deck) {
        validateDeckCommonFields(deck);
        return deckRepository.save(deck);
    }


    @Override
    public Deck deleteDeck(Integer idDeck) {
        Optional<Deck> deckOptional = deckRepository.findById(idDeck);
        if (deckOptional.isPresent()) {
            deckRepository.deleteById(idDeck);
            return deckOptional.get();
        }
        return null;
    }

    @Override
    public Deck updateDeck(Integer idDeck, Deck updatedDeck) {
        Optional<Deck> deckOptional = deckRepository.findById(idDeck);

        if (deckOptional.isPresent()) {
            Deck existingDeck = deckOptional.get();
            validateDeckCommonFields(updatedDeck);
            existingDeck.setDeckName(updatedDeck.getDeckName());
            existingDeck.setFormat(updatedDeck.getFormat());
            existingDeck.setLegal(updatedDeck.isLegal());
            existingDeck.setPrivateDeck(updatedDeck.isPrivateDeck());
            existingDeck.setUser(updatedDeck.getUser());
            existingDeck.setDeckCards(updatedDeck.getDeckCards());
            return deckRepository.save(existingDeck);
        }
        throw new IllegalArgumentException("Deck not found");
    }
}