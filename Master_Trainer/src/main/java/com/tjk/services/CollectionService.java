import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    // Adds a new card to the user's collection
    public Collection addCardToCollection(Collection collection) throws IllegalArgumentException {
        // Check if the card already exists in the user's collection
        Optional<Collection> existingCollection = collectionRepository.findByIdCardAndIdUser(collection.getIdCard(), collection.getIdUser());
        if (existingCollection.isPresent()) {
            throw new IllegalArgumentException("Card is already present in the user's collection.");
        }

        // Validate that the quantity is positive
        if (collection.getQuantity() == null || collection.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number.");
        }

        // Save the collection in the database
        return collectionRepository.save(collection);
    }

    // Updates an existing card in the user's collection
    public Collection updateCardInCollection(Collection collection) throws IllegalArgumentException {
        Optional<Collection> existingCollection = collectionRepository.findByIdCardAndIdUser(collection.getIdCard(), collection.getIdUser());

        if (!existingCollection.isPresent()) {
            throw new IllegalArgumentException("Card is not found in the user's collection.");
        }

        // Validate the quantity (must be greater than 0)
        if (collection.getQuantity() == null || collection.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number.");
        }

        // Update the existing collection entry
        Collection existingEntry = existingCollection.get();
        existingEntry.setQuantity(collection.getQuantity());
        existingEntry.setFavourite(collection.getFavourite());

        return collectionRepository.save(existingEntry);
    }

    // Deletes a card from the user's collection
    public void deleteCardFromCollection(String idCard, Integer idUser) throws IllegalArgumentException {
        Optional<Collection> existingCollection = collectionRepository.findByIdCardAndIdUser(idCard, idUser);

        if (!existingCollection.isPresent()) {
            throw new IllegalArgumentException("Card not found in the user's collection.");
        }

        // Delete the card from the collection
        collectionRepository.delete(existingCollection.get());
    }

    // Marks a card as favourite in the user's collection
    public void setFavourite(String idCard, Integer idUser, boolean isFavourite) throws IllegalArgumentException {
        Optional<Collection> existingCollection = collectionRepository.findByIdCardAndIdUser(idCard, idUser);

        if (!existingCollection.isPresent()) {
            throw new IllegalArgumentException("Card not found in the user's collection.");
        }

        // Set the card as favourite
        Collection collection = existingCollection.get();
        collection.setFavourite(isFavourite);

        collectionRepository.save(collection);
    }

    // Retrieves all cards in a user's collection
    public List<Collection> getAllCardsInCollection(Integer idUser) {
        return collectionRepository.findByIdUser(idUser);
    }

    // Retrieves a specific card from a user's collection
    public Collection getCardFromCollection(String idCard, Integer idUser) throws IllegalArgumentException {
        Optional<Collection> existingCollection = collectionRepository.findByIdCardAndIdUser(idCard, idUser);

        if (!existingCollection.isPresent()) {
            throw new IllegalArgumentException("Card not found in the user's collection.");
        }

        return existingCollection.get();
    }
}
