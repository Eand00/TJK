package com.tjk.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
