package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class representing a Card in the database. 
 * This class maps to the "Card" table in the database.
 */
@Entity
@Table(name = "pokemoncard")
public class Card {

    /**
     * The unique identifier for the card.
     */
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCard;  
    
    /**
     * The set to which this card belongs.
     */
    @Column(name = "set_name")
    private String set;

    /**
     * The series of the card.
     */
    private String series;

    /**
     * The publisher of the card.
     */
    private String publisher;

    /**
     * The generation of the card.
     */
    private String generation;

    /**
     * The release date of the card.
     */
    private String releaseDate;  
    
    /**
     * The artist who designed the card (nullable).
     */
    @Column(nullable = true)
    private String artist;
    
    /**
     * The name of the card.
     */
    @Column(name = "name_card")
    private String name;

    /**
     * The set number of the card.
     */
    @Column(name = "set_num")
    private String setNum;

    /**
     * The types of the card (nullable).
     */
    @Column(nullable = true, name = "types_card")
    private String types;
    
    /**
     * The supertypes of the card.
     */
    @Column(name = "supertype")
    private String supertypes;
    
    /**
     * The subtypes of the card (nullable).
     */
    @Column(nullable = true)
    private String subtypes;

    /**
     * The level of the card (nullable).
     */
    @Column(nullable = true, name = "level_card")
    private String level;  
    
    /**
     * The health points (HP) of the card (nullable).
     */
    @Column(nullable = true)
    private String hp;  
    
    /**
     * The name of the card this card evolves from (nullable).
     */
    @Column(nullable = true)
    private String evolvesFrom;
    
    /**
     * The name of the card this card evolves to (nullable).
     */
    @Column(nullable = true)
    private String evolvesTo;
    
    /**
     * The abilities of the card (nullable).
     */
    @Column(nullable = true)
    private String abilities;

    /**
     * The attacks of the card (nullable).
     */
    @Column(nullable = true)
    private String attacks;

    /**
     * The weaknesses of the card (nullable).
     */
    @Column(nullable = true)
    private String weakness;

    /**
     * The retreat cost of the card (nullable).
     */
    @Column(nullable = true)
    private String retreatCost;

    /**
     * The converted retreat cost of the card (nullable).
     */
    @Column(nullable = true)
    private String converted;  
    
    /**
     * The rarity of the card (nullable).
     */
    @Column(nullable = true)
    private String rarity;

    /**
     * The flavor text of the card (nullable).
     */
    @Column(nullable = true)
    private String flavourText;

    /**
     * The national Pokédex number of the card (nullable).
     */
    @Column(nullable = true)
    private String nationalPokedexNumbers;  
    
    /**
     * The legalities of the card.
     */
    private String legalities;

    /**
     * The resistances of the card (nullable).
     */
    @Column(nullable = true)
    private String resistances;

    /**
     * The rules associated with the card (nullable).
     */
    @Column(nullable = true)
    private String rules;

    /**
     * The regulation mark of the card (nullable).
     */
    @Column(nullable = true)
    private String regulationMark;

    /**
     * The ancient trait of the card (nullable).
     */
    @Column(nullable = true)
    private String ancientTrait;

    /**
     * The image URL of the card.
     */
    private String img;

    // Getters and Setters

    public String getIdCard() {
        return idCard;
    }


    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    
    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getSupertypes() {
        return supertypes;
    }

    public void setSupertypes(String supertypes) {
        this.supertypes = supertypes;
    }

    public String getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(String subtypes) {
        this.subtypes = subtypes;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public String getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(String evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getAttacks() {
        return attacks;
    }

    public void setAttacks(String attacks) {
        this.attacks = attacks;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }

    public String getConverted() {
        return converted;
    }

    public void setConverted(String converted) {
        this.converted = converted;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getFlavourText() {
        return flavourText;
    }

    public void setFlavourText(String flavourText) {
        this.flavourText = flavourText;
    }

    public String getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    public void setNationalPokedexNumbers(String nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
    }

    public String getLegalities() {
        return legalities;
    }

    public void setLegalities(String legalities) {
        this.legalities = legalities;
    }

    public String getResistances() {
        return resistances;
    }

    public void setResistances(String resistances) {
        this.resistances = resistances;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getRegulationMark() {
        return regulationMark;
    }

    public void setRegulationMark(String regulationMark) {
        this.regulationMark = regulationMark;
    }

    public String getAncientTrait() {
        return ancientTrait;
    }

    public void setAncientTrait(String ancientTrait) {
        this.ancientTrait = ancientTrait;
    }

	public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    @Override
    public String toString() {
    	return "Card [idCard=" + idCard + ", set=" + set + ", series=" + series + ", publisher=" + publisher
    			+ ", generation=" + generation + ", releaseDate=" + releaseDate + ", artist=" + artist + ", name="
    			+ name + ", setNum=" + setNum + ", types=" + types + ", supertypes=" + supertypes + ", subtypes="
    			+ subtypes + ", level=" + level + ", hp=" + hp + ", evolvesFrom=" + evolvesFrom + ", evolvesTo="
    			+ evolvesTo + ", abilities=" + abilities + ", attacks=" + attacks + ", weakness=" + weakness
    			+ ", retreatCost=" + retreatCost + ", converted=" + converted + ", rarity=" + rarity + ", flavourText="
    			+ flavourText + ", nationalPokedexNumbers=" + nationalPokedexNumbers + ", legalities=" + legalities
    			+ ", resistances=" + resistances + ", rules=" + rules + ", regulationMark=" + regulationMark
    			+ ", ancientTrait=" + ancientTrait + ", img=" + img + "]";
    }
}
