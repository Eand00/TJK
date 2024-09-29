package com.tjk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "collection")
@IdClass(CollectionId.class)
public class Collection {
	
	@Id
    @Column(name = "id_card", nullable = false)
    private String idCard;

    @Id
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    private Boolean favourite;

    private Integer quantity;

    // Foreign Key Relationships
    @ManyToOne
    @JoinColumn(name = "id_card", insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    // Getters and Setters
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Card getCard() {
        return card;
    }

    public void seCard(Card card) {
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

}
