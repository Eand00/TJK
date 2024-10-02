package com.tjk.services;

import java.util.List;

import com.tjk.entities.Card;

public interface CardService {
	
	List<Card> findByCardName(String name);
}
