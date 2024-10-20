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
 * Entity class representing a Collection in the database.
 * This class maps to the "collections" table in the database.
 */
@Entity
@Table(name = "collections")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Collection {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @EmbeddedId
    private CollectionId id;

	@ManyToOne
	@MapsId("idCard")
    @JoinColumn(name = "id_card", nullable = false)
    private Card card;

	@ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "favourite")
    private Boolean favourite;

    @Column(name = "quantity")
    private Integer quantity;

}
