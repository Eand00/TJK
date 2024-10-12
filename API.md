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
To use the APIs let's setup the **Authentication** section with the *Username* and *Password*.

```
Username: TestAPI
Password: Password123*
```

# Card

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


# Deck

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


## <span id="collection-get" style="color:lightblue;">GET</span>

### <span id="collection-get-getall">getAll:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/get_all`      
This request gets all the collections in the DB.     

### <span id="collection-get-getusercollection">getUserCollection:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/{userId}`      
This request gets all the cards for the user.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/1`      
> Gets all the cards for the user with the id `1`.

### <span id="collection-get-getfavouritecards">getFavouriteCards:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/favourite/{userId}`      
This request gets all the cards marked as favourite for the user.     
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/favourite/1`      
> Gets all the favourite cards for the user with the id `1`.

### <span id="collection-get-getbyuserandbycard">getByUserAndByCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/get_card/{userId}/{cardId}`      
This request gets the card for the user.       
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/get_card/1/base1-1`      
> Gets the card with the id `base1-1` in the collection of the user `1`.


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

### <span id="collection-put-markcardasfavourite">markCardAsFavourite:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/mark_favourite/{userId}/{cardId}`       
This request marks as a favourite a card for the user. If the collection is not in the DB it adds the collection to it.
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/mark_favourite/1/base1-1`      
> Marks the card with the id `base1-1` as a favourite in the collection of the user `1`.


## <span id="collection-post" style="color:red;">DELETE</span>

### <span id="collection-delete">deleteCard:</span>
**Endpoint**: `http://localhost:1699/master_trainer/collections/delete_card/{userId}/{cardId}`      
This request removes a card from the collection of the user.
> *Example usage*:        
> `http://localhost:1699/master_trainer/collections/delete_card/1/base1-1`      
> Removes the card with the id `base1-1` from the collection of the user `1`.


# DeckCards
