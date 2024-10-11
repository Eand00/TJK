/*package com.tjk.repos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tjk.entities.Card;

public interface CardDAO extends JpaRepository<Card, String> {

	// Finds if present a card with a specific id
	Optional<Card> findByIdCard(String id);
	
	// Finds a list of cards in a set
	List<Card>  findBySetName(String set);
	
	// Finds a list of cards with a specific name
	List<Card> findByNameCard(String name);
	
	// Finds a list of cards with a specific set of types
	List<Card> findByTypesCardContaining(String types);
	
	// Finds a list of cards with a specific set of subtypes
	List<Card> findBySubtypesContaining(String subtypes);
	
	// Finds a list of cards with a specific rarity
	List<Card> findByRarity(String rarity);
	
	List<Card> findByArtist(String artist);
	
	
	
	// See CardService Interface for all the missing methods.
	
}*/

package com.tjk.repos; 
// All actions and methods still has to be moved, I left the previous code above on purpose
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.tjk.entities.Card;

@Repository
public class CardDAO {

    private Connection connection;

    public CardDAO(Connection connection) {
        this.connection = connection;
    }

    // Restituisce tutte le carte
    public List<Card> findAll() throws SQLException {
        String query = "SELECT * FROM cards";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            List<Card> cards = new ArrayList<>();
            while (rs.next()) {
                Card card = new Card();
                card.setName(rs.getString("name"));
                // Other card attributes must be added
                cards.add(card);
            }
            return cards;
        }
    }

    // Restituisce carte filtrate per nome
    public List<Card> findByName(String name) throws SQLException {
        String query = "SELECT * FROM cards WHERE name LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            List<Card> cards = new ArrayList<>();
            while (rs.next()) {
                Card card = new Card();
                card.setName(rs.getString("name"));
             // Other card attributes must be added
                cards.add(card);
            }
            return cards;
        }
    }

    // Ricerca dinamica di carte con filtri combinati
    public List<Card> searchCards(String name, Integer level, String set, String type, String supertype) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM cards WHERE 1=1");

        if (name != null && !name.isEmpty()) {
            query.append(" AND name LIKE ?");
        }
        if (level != null) {
            query.append(" AND level = ?");
        }
        if (set != null && !set.isEmpty()) {
            query.append(" AND set = ?");
        }
        if (type != null && !type.isEmpty()) {
            query.append(" AND type = ?");
        }
        if (supertype != null && !supertype.isEmpty()) {
            query.append(" AND supertype = ?");
        }

        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;

            if (name != null && !name.isEmpty()) {
                stmt.setString(paramIndex++, "%" + name + "%");
            }
            if (level != null) {
                stmt.setInt(paramIndex++, level);
            }
            if (set != null && !set.isEmpty()) {
                stmt.setString(paramIndex++, set);
            }
            if (type != null && !type.isEmpty()) {
                stmt.setString(paramIndex++, type);
            }
            if (supertype != null && !supertype.isEmpty()) {
                stmt.setString(paramIndex++, supertype);
            }

            ResultSet rs = stmt.executeQuery();
            List<Card> cards = new ArrayList<>();
            while (rs.next()) {
                Card card = new Card();
                card.setName(rs.getString("name"));
                card.setLevel(rs.getInt("level"));
                card.setSet(rs.getString("set"));
                card.setType(rs.getString("type"));
                card.setSupertype(rs.getString("supertype"));
             // Other card attributes must be added
                cards.add(card);
            }
            return cards;
        }
    }
}

