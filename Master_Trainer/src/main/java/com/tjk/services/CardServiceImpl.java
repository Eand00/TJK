package com.tjk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjk.entities.Card;
import com.tjk.repos.CardDAO;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO dao;
	
	@Override
	public List<Card> findByCardName(String name) {
		return dao.findByName(name);
	}

}
