package com.tjk.services;

public interface DeckCardsService {
	
	public void addCardToDeck(Integer deckId, String cardId, Integer quantity);// need int totalCardsInDeck = dao.getTotalCardsInDeck(deckId);
	public void removeCardFromDeck(Integer deckId, String cardId);
	public int getTotalCardsInDeck(Integer deckId);//need to make a custom querry in the dao
	public boolean isDeckValid(Integer deckId);
}
