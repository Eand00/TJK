package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {
	
	Optional<Collection> findByIdUserAndIdCard(Integer idUser, String idCard);
	
    // Finds a list of cards in owned by a user.
    List<Collection> findByIdUser(Integer idUser);
    
    @Query(value="SELECT * FROM collections WHERE favourite=true", nativeQuery = true)
    List<Collection> findFavouriteByUserId(Integer idUser);

}
