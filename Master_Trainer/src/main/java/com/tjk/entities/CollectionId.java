package com.tjk.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class CollectionId implements Serializable {
	
	@Column(name = "id_card")
	private String idCard;
	
	@Column(name = "id_user")
    private Integer idUser;

    // Default constructor
    public CollectionId() {
    }

    public CollectionId(String idCard, Integer idUser) {
        this.idCard = idCard;
        this.idUser = idUser;
    }

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

    // hashCode and equals (important for composite keys)
    @Override
    public int hashCode() {
        return Objects.hash(idCard, idUser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionId that = (CollectionId) o;
        return Objects.equals(idCard, that.idCard) && Objects.equals(idUser, that.idUser);
    }

}
