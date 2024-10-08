package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {
	
	Optional<Collection> findByIdUserAndIdCard(Integer idUser, String idCard);
	
    // Finds a list of cards in owned by a user.
    List<Collection> findByIdUser(Integer idUser);
    
    // List of Collection of Favourite cards that belong to a certain user, given his idUser
    @Query(value="SELECT * FROM collections WHERE favourite=true AND id_user=:idUser", nativeQuery = true)
    List<Collection> findFavouriteByUserId(@Param("idUser") Integer idUser);

}
