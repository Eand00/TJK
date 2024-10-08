package com.tjk.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjk.entities.Collection;
import com.tjk.entities.CollectionId;

public interface CollectionDAO extends JpaRepository<Collection, CollectionId> {
	
	// Searches a certain card in the collection of a user
	@Query(value = "SELECT * FROM collections WHERE (id_user=:idUser AND id_card=:idCard)", nativeQuery = true)
	Optional<Collection> findByIdUserAndIdCard(@Param("idUser") Integer idUser, @Param("idCard") String idCard);
	
    // Finds a list of cards in owned by a user.
	@Query(value = "SELECT * FROM collections WHERE id_user=:idUser", nativeQuery = true)
    List<Collection> findByIdUser(@Param("idUser") Integer idUser);
    
    // List of Collection of Favourite cards that belong to a certain user, given his idUser
    @Query(value = "SELECT * FROM collections WHERE (favourite=true AND id_user=:idUser)", nativeQuery = true)
    List<Collection> findFavouritesByUserId(@Param("idUser") Integer idUser);

    // Deletes a certain card from the collection of a user
    @Query(value = "DELETE FROM collections WHERE (id_user=:idUser AND id_card=:idCard)", nativeQuery = true)
    void deleteCard(@Param("idUser") Integer idUser, @Param("idCard") String idCard);
 
    // Marks a card as a favourite or not favourite
    @Query(value = "UPDATE collections SET favourite = :isFavourite WHERE (id_user = :idUser AND id_card = :idCard)", nativeQuery = true)
    void markAsFavourite(@Param("idUser") Integer idUser, @Param("idCard") String idCard, @Param("isFavourite")boolean isFavourite);

    // Adds a card in the collection of a user
    @Query(value = "INSERT INTO collections (id_card, id_user, favourite, quantity) VALUES (:idCard, :idUser, 0, :quantity)", nativeQuery = true)
    void addCardByCardIdAndUserId(@Param("idCard") String idCard, @Param("idUser") Integer idUser, @Param("quantity") Integer quantity);
    
    // Edit the quantity of a card in the collection of a user
    @Query(value = "UPDATE collections SET quanity = :quantity WHERE (id_user = :idUser AND id_card = :idCard)", nativeQuery = true)
    void editCardByCardIdAndUserId(@Param("idUser") Integer idUser, @Param("idCard") String idCard, @Param("quantity") Integer quantity);
    
}
