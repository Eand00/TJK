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
