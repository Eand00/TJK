package com.tjk.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Represents a composite key for the 'Collection' entity, consisting of 'idCard' and 'idUser'.
 * This class is marked as embeddable, meaning it can be used as an embedded ID in a JPA entity.
 * It implements Serializable to ensure it can be serialized for persistence and deserialization.
 */
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
