package com.tjk.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a DeckCards in the database.
 * This class maps to the "decks_cards" table and holds information about a cards of the deck.
 */
@Entity
@Table(name = "decks_cards")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DeckCards {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	@EmbeddedId
    private DeckCardsId id;

    @ManyToOne
    @MapsId("idCard")
    @JoinColumn(name = "id_card", nullable = false)
    private Card card;

    @ManyToOne
    @MapsId("idDeck")
    @JoinColumn(name = "id_deck", nullable = false)
    private Deck deck;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}

