package com.tjk.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Represents a composite key for the 'DeckCards' entity, consisting of 'idCard' and 'idDeck'.
 * This class is marked as embeddable, meaning it can be used as an embedded ID in a JPA entity.
 * It implements Serializable to ensure it can be serialized for persistence and deserialization.
 */
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
