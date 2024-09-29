package com.tjk.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tjk.entities.Card;

public interface CardDAO extends JpaRepository<Card, String> {

	Optional<Card> findByIdCard(String id);

}
