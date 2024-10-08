package com.tjk.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class CollectionId implements Serializable {
	
	@Column(name = "id_card")
	private String idCard;
	
	@Column(name = "id_user")
    private Integer idUser;

    public CollectionId() {
    }

    public CollectionId(String idCard, Integer idUser) {
        this.idCard = idCard;
        this.idUser = idUser;
    }
}
