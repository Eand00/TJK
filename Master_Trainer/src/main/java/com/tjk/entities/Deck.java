package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a Deck in the database.
 * This class maps to the "Deck" table and holds information about a deck of cards.
 */
@Entity
@Table(name = "decks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Deck {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deck", nullable = false)
    private Integer idDeck;

    @Column(name = "deck_name", nullable = false)
    private String deckName;

    @Column(name = "format", nullable = false)
    private String format;
    
    @Column(name = "legal", nullable = false)
    private Boolean legal;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;
    
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cover_card", referencedColumnName = "id_card", nullable = false)
    private Card coverCard; 
    
}
