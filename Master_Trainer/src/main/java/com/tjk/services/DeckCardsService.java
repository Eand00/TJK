import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeckCardsService {

    @Autowired
    private DeckCardsRepository deckCardsRepository;

    // Adds a card to a deck with a specified quantity
    public DeckCards addCardToDeck(DeckCards deckCards) throws IllegalArgumentException {
        // Check if the card is already in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(new DeckCardsId(deckCards.getIdCard(), deckCards.getIdDeck().getIdDeck()));
        if (existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("This card is already in the deck.");
        }

        // Validate the input data
        validateDeckCards(deckCards);

        // Save the new DeckCards entry
        return deckCardsRepository.save(deckCards);
    }

    // Updates the quantity of a card in a deck
    public DeckCards updateCardInDeck(DeckCards deckCards) throws IllegalArgumentException {
        // Check if the card is in the deck
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(new DeckCardsId(deckCards.getIdCard(), deckCards.getIdDeck().getIdDeck()));
        if (!existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("This card is not present in the deck.");
        }

        // Validate the updated data
        validateDeckCards(deckCards);

        // Update the DeckCards entry in the database
        return deckCardsRepository.save(deckCards);
    }

    // Removes a card from a deck
    public void removeCardFromDeck(String idCard, String idDeck) throws IllegalArgumentException {
        DeckCardsId deckCardsId = new DeckCardsId(idCard, idDeck);
        Optional<DeckCards> existingDeckCards = deckCardsRepository.findById(deckCardsId);
        if (!existingDeckCards.isPresent()) {
            throw new IllegalArgumentException("The card is not in the deck.");
        }

        // Remove the card from the deck
        deckCardsRepository.delete(existingDeckCards.get());
    }

    // Retrieves all cards in a specific deck
    public List<DeckCards> getCardsInDeck(String idDeck) {
        return deckCardsRepository.findByIdDeckIdDeck(idDeck);
    }

    // Validates the fields of a DeckCards entity
    private void validateDeckCards(DeckCards deckCards) throws IllegalArgumentException {
        if (deckCards.getIdCard() == null || deckCards.getIdCard().isEmpty()) {
            throw new IllegalArgumentException("Card ID cannot be null or empty.");
        }
        if (deckCards.getIdDeck() == null || deckCards.getIdDeck().getIdDeck() == null) {
            throw new IllegalArgumentException("Deck ID cannot be null.");
        }
        if (deckCards.getQuantity() == null || deckCards.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer.");
        }
    }
}
