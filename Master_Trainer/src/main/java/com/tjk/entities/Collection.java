package com.tjk.entities;

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
	@ManyToOne
    @JoinColumn(name = "id_card", referencedColumnName = "id_card", nullable = false)
    private Card idCard;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User idUser;

    private Boolean favourite;

    private Integer quantity;

	public Card getIdCard() {
		return idCard;
	}

	public void setIdCard(Card idCard) {
		this.idCard = idCard;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
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
}
