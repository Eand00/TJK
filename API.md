# API Requests for Master Trainer
These are the different requests that can be made in the platform to use the APIs (such as Postman or Thunder Client).

## Sections
- [Authentication](#authentication)
- [Card](#card)
- [User](#user)
- [Deck](#deck)
- [Collection](#collection)
- [DeckCards](#deckcards)

# Authentication
To use the APIs let's setup the **Authentication**(Basic Authentication
) section with the *Username* and *Password*.

```
Username: TestAPI
Password: Password123*
```


# Card
Go to:
- [GET](#card-get)
    - [getAllCards](#card-getallcards)
    - [getCardByCardId](#car-getcardbyid)
    - [getCardByName](#card-getcardbysinglefilter)
    - [getCardBySetName](#card-getcardbysinglefilter)
    - [getCardBySeries](#card-getcardbysinglefilter)
    - [getCardByPublisher](#card-getcardbysinglefilter)
    - [getCardByGeneration](#card-getcardbysinglefilter)
    - [getCardByArtist](#card-getcardbysinglefilter)
    - [getCardByTypesCard](#card-getcardbysinglefilter)
    - [getCardBySupertype](#card-getcardbysinglefilter)
    - [getCardBySubtypes](#card-getcardbysinglefilter)
    - [getCardByEvolvesFrom](#card-getcardbysinglefilter)
    - [getCardByEvolvesTo](#card-getcardbysinglefilter)
    - [getCardByRarity](#card-getcardbysinglefilter)
    - [getCardByLegalities](#card-getcardbysinglefilter)
    - [getCardByRegulationMark](#card-getcardbysinglefilter)
    - [filterCards](#card-getcardbymultiplefilter)
- [Top of the document](#)

## <span id="card-get" style="color:lightblue;">GET</span>

### <span id="card-getallcards">getAllCards:</span>
**Endpoint**: `http://localhost:1699/master_trainer/cards`      
This request gets all the cards in the DB. 

---
## <span id="car-getcardbyid">getCardByCardId:</span>
**Endpoint**: `http://localhost:1699/master_trainer/cards/cardId/{cardId}`      
This request gets a specific card by its id.
> *Example usage*:        
> `http://localhost:1699/master_trainer/cards/cardId/base1-1`      
> Gets the card with the id `base1-1`.

---
## <span id="card-getcardbysinglefilter">getCardBy{Parameter}</span>
**Endpoint**: `http://localhost:1699/master_trainer/cards/[parameter]/{parameter value}`
> *Example usage*:        
> `http://localhost:1699/master_trainer/cards/generation/third`      
> Gets the cards of the `third` generation.  

[Parameter list](#card-filterparamlist)

---
## <span id="card-getcardbymultiplefilter">filterCards</span>  
**Endpoint**: `http://localhost:1699/master_trainer/cards/filter?[parammeter]={parameter value}&[other parammeter]={other parameter value}`
> *Example usage*:  
> `http://localhost:1699/master_trainer/cards/filter?nameCard=Chespin&subtypes=Basic&legalities=unlimited`  
> Gets the cards tha contain `Chespin` in their name, of `Basic` subtype and `unlimited` legality.  

[Parameter list](#card-filterparamlist)


### <span id="card-filterparamlist">Filter Query Parameters</span>

| Parameter       |Example                   | Required | Description                        |
|-----------------|--------------------------|----------|------------------------------------|
| `nameCard`      | Pikachu                  | No       | Filters by the card's name.        |
| `setName`       | Wizards Black Star Promos| No       | Filters by the set.                |
| `series`        | Base                     | No       | Filters by the serie.              |
| `publisher`     | WOTC                     | No       | Filters by the publisher.          |
| `generation`    | First                    | No       | Filters by the generation.         |
| `artist`        | Kagemaru Himeno          | No       | Filters by the artist.             |
| `typesCard`     | Lightning                | No       | Filters by the card's types.       |
| `supertype`     | Pokémon                  | No       | Filters by the card's supertype.   |
| `subtypes`      | Basic                    | No       | Filters by the card's subtypes.    |
| `evolvesFrom`   | Zubat                    | No       | Filters by the card's evolution.   |
| `evolvesTo`     | Raichu                   | No       | Filters by the card's prevolution. |
| `rarity`        | Promo                    | No       | Filters by the rarity.             |
| `legalities`    | unlimited                | No       | Filters by the card's legalities.  |
| `regulationMark`| G                        | No       | Filters by the regulation mark.    |

---

# User
Go to:
- [GET](#user-get)
    - [getAllUsers](#user-get-getallusers)
    - [getUserById](#user-get-getuserbyid)
    - [getUserByUsername](#user-get-getuserbyusername)
- [POST](#user-post)
    - [createUser](#user-post-createuser)
- [PUT](#user-put)
    - [updateUser](#user-put-updateuser)
    - [changePassword](#user-put-changepassword)
    - [changeUserPassword](#user-put-changeuserpassword)
- [DELETE](#user-delete)
    - [deleteUser](#user-delete-deleteuser)
- [Top of the document](#)


## <span id="user-get" style="color:lightblue;">GET</span>

### <span id="user-get-getallusers">getAllUsers:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users`      
This request gets all the users in the DB.  

---
## <span id="user-get-getuserbyid">getUserById:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/{id}`      
This request gets a specific user by their id.
> *Example usage*:        
> `http://localhost:1699/master_trainer/users/1`      
> Gets the user with the id `1`.

---
## <span id="user-get-getuserbyusername">getUserByUsername:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/{username}`      
This request gets a user by their username.
> *Example usage*:        
> `http://localhost:1699/master_trainer/users/TestAPI`      
> Gets the user with the username `TestAPI`.

---
[Go back to the selection](#user)     

---

## <span id="user-post" style="color:yellow;">POST</span>

### <span id="user-post-createuser">createUser:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/create_user`      
This request adds a user in the db.     
In the **body** of the request you should add a json like this:
```json
{
    "privateProfile": false,
    "firstName": "Mario",
    "username": "user1",
    "surname": "Rossi",
    "password": "Password1!",
    "role": "user"
}
```

---
[Go back to the selection](#user)     

---

## <span id="user-put" style="color:orange;">PUT</span>

### <span id="user-put-updateuser">updateUser:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/update-user/{id}`       
This request edits the user with the id given.              
In the **body** of the request you should add a json like this:
```json
{
    "username": "user1updated",
    "password": "Password123!",
    "firstName": "MarioUpdated",
    "surname": "RossiUpdated",
    "privateProfile": false,
    "role": "USER"
}
```
> *Example usage*:        
> `http://localhost:1699/master_trainer/users/update-user/2`      
> Edits the user with the id `2`.

---
### <span id="user-put-changepassword">changePassword:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/change_password`       
This request changes the password for the user.              
In the **body** of the request you should add a json like this:
```json
{
    "oldPassword": "Password123!",
    "newPassword": "NewPassword123?"
}
```

---
### <span id="user-put-changeuserpassword">changeUserPassword:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/change_user_password/{id}`        
This request, if you are logged as an `ADMIN` user, changes the password for any user given their id.       
In the **body** of the request you should add a json like this:
```json
{
   "newPassword": "NewPassword123?"
}
```
> *Example usage*:        
> `http://localhost:1699/master_trainer/users/change_user_password/2`      
> Edits the password for the user with the id `2`.

---
[Go back to the selection](#user)     

---

## <span id="user-delete" style="color:red;">DELETE</span>

### <span id="user-delete-deleteuser">deleteUser:</span>
**Endpoint**: `http://localhost:1699/master_trainer/users/delete-user/{id}`  
This request deletes the user with the id given.
> *Example usage*:        
> `http://localhost:1699/master_trainer/users/delete-user/2`      
> Deletes the user with the id `2`.

---
[Go back to the selection](#user)     

---


# Deck
Go to:
- [GET](#deck-get)
    - [getDeckByName](#deck-get-getdeckbyname)
    - [getDeckByIdUser](#deck-get-getdeckbyiduser)
    - [getPublicDecks](#deck-get-getpublicdecks)
    - [getLegalDecks](#deck-get-getlegaldecks)
    - [getDeckByIdDeck](#deck-get-getdeckbyiddeck)
- [POST](#deck-post)
    - [createDeck](#deck-post-createdeck)
- [PUT](#deck-put)
    - [updateDeck](#deck-put-updatedeck)
- [DELETE](#deck-delete)
    - [deleteDeck](#deck-delete-deletedeck)
- [Top of the document](#)

<!--  -->
## <span id="deck-get" style="color:lightblue;">GET</span>

### <span id="deck-get-getdeckbyname">getDeckByName:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/name/{deckName}`           
This request gets the deck by its name.  
> *Example usage*:        
> `http://localhost:1699/master_trainer/decks/name/Charizard`      
> Gets the deck with the name `Charizard`.

---
### <span id="deck-get-getdeckbyiduser">getDeckByIdUser:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/user/{idUser}`           
This request gets all the decks for the user given.  
> *Example usage*:        
> `http://localhost:1699/master_trainer/decks/user/2`      
> Gets the decks for the user with the id `2`.

---
### <span id="deck-get-getpublicdecks">getPublicDecks:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/public`           
This request gets all the decks marked as public.  

---
### <span id="deck-get-getlegaldecks">getLegalDecks:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/legal`           
This request gets all the decks marked as legal.  

---
### <span id="deck-get-getdeckbyiddeck">getDeckByIdDeck:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/{idDeck}`           
This request gets the deck with the id given.  
> *Example usage*:        
> `http://localhost:1699/master_trainer/decks/4`      
> Gets the deck with the id `4`.

---
[Go back to the selection](#deck)     

---

## <span id="deck-post" style="color:yellow;">POST</span>

### <span id="deck-post-createdeck">createDeck:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/create_deck`      
This request adds a deck for a user.              
In the **body** of the request you should add a json like this:
```json
{
    "deckName": "Charizard",
    "format": "Legal",
    "legal": true,
    "isPrivate": false,
    "user": {
        "idUser": 2
    },
    "coverCard": {
        "idCard": "base1-100"
    }
}
```

---
[Go back to the selection](#deck)     

---

## <span id="deck-put" style="color:orange;">PUT</span>

### <span id="deck-put-updatedeck">updateDeck:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/update_deck/{idDeck}`       
This request edits the deck with the id given.              
In the **body** of the request you should add a json like this:
```json
{
    "deckName": "Arcanine",
    "format": "Legal",
    "legal": true,
    "isPrivate": true,
    "user": {
        "idUser": 3
    },
    "coverCard": {
        "idCard": "base1-100"
    }
}
```
> *Example usage*:        
> `http://localhost:1699/master_trainer/decks/update_deck/4`      
> Edits the deck with the id `4`.

---
[Go back to the selection](#deck)     

---

## <span id="deck-delete" style="color:red;">DELETE</span>

### <span id="deck-delete-deletedeck">deleteDeck:</span>
**Endpoint**: `http://localhost:1699/master_trainer/decks/delete_deck/{idDeck}`  
This request deletes the deck with the id given.
> *Example usage*:        
> `http://localhost:1699/master_trainer/decks/delete_deck/3`      
> Deletes the deck with the id `2`.

---
[Go back to the selection](#deck)     

---


# Collection
Go to:
- [GET](#collection-get)
    - [getAll](#collection-get-getall)
    - [getUserCollection](#collection-get-getusercollection)
    - [getFavouriteCards](#collection-get-getfavouritecards)
    - [getByUserAndByCard](#collection-get-getbyuserandbycard)
- [POST](#collection-post)
    - [addCard](#collection-post-addcard)
- [PUT](#collection-put)
    - [editCard](#collection-put-editcard)
    - [markCardAsFavourite](#collection-put-markcardasfavourite)
- [DELETE](#collection-delete)
    - [deleteCard](#collection-delete-deletecard)
- [Top of the document](#)


## <span id="collection-get" style="color:lightblue;">GET</span>

### <span id="collection-get-getall">getAll:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/get_all`      
This request gets all the collections in the DB.     

---
### <span id="collection-get-getusercollection">getUserCollection:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/{userId}`      
This request gets all the cards for the user.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/1`      
> Gets all the cards for the user with the id `1`.

---
### <span id="collection-get-getfavouritecards">getFavouriteCards:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/favourite/{userId}`      
This request gets all the cards marked as favourite for the user.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/favourite/1`      
> Gets all the favourite cards for the user with the id `1`.

---
### <span id="collection-get-getbyuserandbycard">getByUserAndByCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/get_card/{userId}/{cardId}`      
This request gets the card for the user.       
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/get_card/1/base1-1`      
> Gets the card with the id `base1-1` in the collection of the user `1`.

---
[Go back to the selection](#collection)     

---

## <span id="collection-post" style="color:yellow;">POST</span>

### <span id="collection-post-addcard">addCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/add_card`      
This request adds a card for the user. If the collection is already in the DB it adds the quantity given to the current quantity.       
In the **body** of the request you should add a json like this:
```json
{
    "id": {
        "idCard": "base1-1",
        "idUser": 1
    },
    "card": {
            "idCard": "base1-1"
    },
     "user": {
            "idUser": 1
     },
    "favourite": false,
    "quantity": 1
}
```

---
[Go back to the selection](#collection)     

---

## <span id="collection-put" style="color:orange;">PUT</span>

### <span id="collection-put-editcard">editCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/edit_card`       
This request edits a card for the user. If the collection is not in the DB it adds the collection to it.        
In the **body** of the request you should add a json like this:
```json
{
    "id": {
        "idCard": "base1-1",
        "idUser": 1
    },
    "card": {
            "idCard": "base1-1"
    },
     "user": {
            "idUser": 1
     },
    "favourite": false,
    "quantity": 2
}
```

---
### <span id="collection-put-markcardasfavourite">markCardAsFavourite:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/mark_favourite/{userId}/{cardId}`       
This request marks as a favourite a card for the user. If the collection is not in the DB it adds the collection to it.
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/mark_favourite/1/base1-1`      
> Marks the card with the id `base1-1` as a favourite in the collection of the user `1`.

---
[Go back to the selection](#collection)     

---

## <span id="collection-delete" style="color:red;">DELETE</span>

### <span id="collection-delete-deletecard">deleteCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/delete_card/{userId}/{cardId}`      
This request removes a card from the collection of the user.
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/delete_card/1/base1-1`      
> Removes the card with the id `base1-1` from the collection of the user `1`.

---
[Go back to the selection](#collection)     

---


# DeckCards
Go to:
- [GET](#deckcards-get)
    - [getCardsInDeck](#deckcard-get-getcardsindeck)
    - [getTotalCardsInDeck](#deckcard-get-gettotalcardindeck)
    - [isDeckValid](#deckcard-get-isdeckvalid)
- [POST](#deckcards-post)
    - [addCardToDeck](#deckcards-post-addcard)
- [PUT](#deckcards-put)
    - [updateCardQuantityInDeck](#deckcards-put-updatecardquantityindeck)
- [DELETE](#deckcards-delete)
    - [removeCardFromDeck](#deckcards-delete-deletecardfromdeck)
- [Top of the document](#)

## <span id="deckcards-get" style="color:lightblue;">GET</span>

### <span id="deckcard-get-getcardsindeck">getCardsInDeck:</span>
**Endpoint**: `http://localhost:1699/master_trainer/deck-builder/cards-in-deck/{deckId}`      
Gets all the cards of the given deck by `deckid`.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/deck-builder/cards-in-deck/1`      
> Gets all the cards of deck with `deckId=1`.

### <span id="deckcard-get-gettotalcardindeck">getTotalCardsInDeck</span>
**Endpoint**: `http://localhost:1699/master_trainer/deck-builder/total-cards/{deckId}"`  
Gets the total number of cards inside a deck by `deckid`.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/deck-builder/total-cards/1`      
> Gets the total number of cards of deck with `deckId=1`.

## <span id="deckcards-post" style="color:yellow;">POST</span>

### <span id="deckcards-post-addcard">addCardToDeck</span>
**Endpoint**: `http://localhost:1699/master_trainer/deck-builder/add-card?idDeck={param value}&idCard={param value}&quantity={param value}"`  
Adds a positive quantity `quantity` of a card `idCard` in the deck `deckid`.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/deck-builder/add-card?idDeck=1&idCard=base1-3&quantity=4`      
> Add `4` cards with id `base1-3` inside `deckId=1`.


## <span id="deckcards-put" style="color:orange;">PUT</span>

### <span id="deckcards-put-updatecardquantityindeck">updateCardQuantityInDeck</span>
**Endpoint**: `http://localhost:1699/master_trainer/deck-builder/add-card?idDeck={param value}&idCard={param value}&newQuantity={param value}"`  
Changes the quantity `quantity` of a card `idCard` in the deck `deckid`.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/deck-builder/update-quantity?deckId=1&cardId=base1-2&newQuantity=1`      
> Changes the card's with id `base1-3` quantity to `1` inside `deckId=1`.

## <span id="deckcards-delete" style="color:red;">DELETE</span>

### <span id="deckcards-delete-deletecardfromdeck">removeCardFromDeck</span>
**Endpoint**: `http://localhost:1699/master_trainer/deck-builder/add-card?idDeck={param value}&idCard={param value}&newQuantity={param value}"`  
Changes the quantity `quantity` of a card `idCard` in the deck `deckid`.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/deck-builder/delete-card/1/base1-2`      
> Deletes the card with id `base1-2` inside `deckId=1`.