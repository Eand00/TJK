package com.tjk.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjk.entities.Card;
import com.tjk.repos.CardDAO;

@Service
public class CardServiceImpl {

    @Autowired
    private CardDAO cardDAO;

    public List<Card> getAllCards() {
        return cardDAO.findAll();
    }

    public List<Card> getCardsByName(String name) {
        return cardDAO.findByName(name);
    }

    // Metodo di ricerca dinamica con più filtri
    public List<Card> searchCards(String name, Integer level, String set, String type, String supertype) {
        return cardDAO.searchCards(name, level, set, type, supertype);
    }
}