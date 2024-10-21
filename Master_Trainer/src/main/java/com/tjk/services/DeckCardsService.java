package com.tjk.services;

public interface DeckCardsService {

    /**
     * Adds a specified quantity of a card to the deck. If the card already exists in the deck,
     * updates the quantity. Ensures the total number of cards doesn't exceed the deck limit.
     *
     * @param deckId the ID of the deck
     * @param cardId the ID of the card
     * @param quantity the number of cards to add to the deck
     */
    public void addCardToDeck(Integer deckId, String cardId, Integer quantity);

    /**
     * Removes a card from the deck. If the card exists, it is removed completely from the deck.
     *
     * @param deckId the ID of the deck
     * @param cardId the ID of the card
     */
    public void removeCardFromDeck(Integer deckId, String cardId);

    /**
     * Returns the total number of cards in a given deck, summing up all card quantities.
     *
     * @param deckId the ID of the deck
     * @return the total number of cards in the deck
     */
    public int getTotalCardsInDeck(Integer deckId);

    /**
     * Determines if a deck is valid based on predefined rules for deck-building (e.g., card limits, legality, etc.).
     *
     * @param deckId the ID of the deck
     * @return true if the deck is valid, false otherwise
     */
    public boolean isDeckValid(Integer deckId);
}

