package com.tjk.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class DeckCardsId implements Serializable {

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "id_deck")
    private Integer idDeck;

    // Default constructor
    public DeckCardsId() {}

    // Parameterized constructor
    public DeckCardsId(String idCard, Integer idDeck) {
        this.idCard = idCard;
        this.idDeck = idDeck;
    }
}
