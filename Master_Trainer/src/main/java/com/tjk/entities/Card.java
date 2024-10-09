package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a Card in the database. 
 * This class maps to the "Card" table in the database.
 */
@Entity
@Table(name = "pokemoncards")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Card {

    @Id
    @Column(name = "id_card", nullable = false)
    private String idCard;

    @Column(name = "set_name", nullable = false)
    private String setName;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "generation", nullable = false)
    private String generation;

    @Column(name = "release_date", nullable = false)
    private String releaseDate;

    @Column(name = "artist")
    private String artist;

    @Column(name = "name_card", nullable = false)
    private String nameCard;

    @Column(name = "set_num", nullable = false)
    private String setNum;

    @Column(name = "types_card")
    private String typesCard;

    @Column(name = "supertype")
    private String supertype;

    @Column(name = "subtypes", nullable = false)
    private String subtypes;

    @Column(name = "level_card")
    private String levelCard;

    @Column(name = "hp")
    private String hp;

    @Column(name = "evolves_from")
    private String evolvesFrom;

    @Column(name = "evolves_to")
    private String evolvesTo;

    @Column(name = "abilities", columnDefinition = "TEXT")
    private String abilities;

    @Column(name = "attacks", columnDefinition = "TEXT")
    private String attacks;

    @Column(name = "weaknesses")
    private String weaknesses;

    @Column(name = "retreat_cost")
    private String retreatCost;

    @Column(name = "converted")
    private String converted;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "flavour_text", columnDefinition = "TEXT")
    private String flavourText;

    @Column(name = "national_pokedex_numbers")
    private String nationalPokedexNumbers;

    @Column(name = "legalities", nullable = false)
    private String legalities;

    @Column(name = "resistances")
    private String resistances;

    @Column(name = "rules", columnDefinition = "TEXT")
    private String rules;

    @Column(name = "regulation_mark")
    private String regulationMark;

    @Column(name = "ancient_trait", columnDefinition = "TEXT")
    private String ancientTrait;

    @Column(name = "img", columnDefinition = "TEXT", nullable = false)
    private String img;
}
