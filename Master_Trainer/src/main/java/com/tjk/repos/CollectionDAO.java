package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {
	
	Optional<Collection> findByIdUserAndIdCard(Integer idUser, String idCard);
	
    // Finds a list of cards in owned by a user.
    List<Collection> findByIdUser(Integer idUser);

}
