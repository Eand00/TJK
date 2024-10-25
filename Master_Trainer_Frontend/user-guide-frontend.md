# USER GUIDE #

## Index: ##
```
- Introduction
- Home page & Login
- Personal Area
- Pokedex
- Deck Builder
- Deck page
- Series & Sets
- Top Cards
- Regulation
```

## Introduction ##

In this <b>.md</b> file you will find the complete guide for each feature of the site. <br>
To reach the `home page`:
```
- Open the TJK directory
- Follow the path: Master-Trainer-Frontend/html
- Choose the language by going into 'Italian' or 'English' folder (you can change it directly on the site anyway)
- Select home.html
```
All the pages of the site share a `navbar` that allows users to navigate through all the site's pages

## Home page & Login ##

In the `home page` of the site you can:

```
- Move to the other pages using the mid-page buttons
- Login in your personal area with the button to the right with the little image on it
- Change the language of the site by pressing the button next to the login one <br>
```
The buttons in the middle allow the user to navigate to the other sections where he can find:
```
- Personal Area
- Pokedex
- Deck Builder
- Deck page
- Series & Sets
- Top Cards
- Regulation
```
## Personal Area ##

The section dedicated to the `personal area` contains all the user information: <b>profile image, name, surname, date of birth and password</b>. You can find the username under the profile image. All the information can be changed and saved using the two buttons at the bottom of the page. In addition, the user can choose to keep his account information private by turning on the <b>private</b> button.
> **Note**: Users can navigate the site without logging in but cannot access their collection, the Deck Builder, or the Top Cards page. <br><br>

## Pokedex ##

The `pokedex` page contains all the existing pokemon cards, showed by an image and the correlated name.
On top of the page there is a <b>search bar </b>and a <b>filter button</b>. The filer button opens a menu containing:
```
- type
- sub-type
- format
- element
- pack
- rarity
- favourite (checkbox)
- owned (checkbox)
```
All of the <b>filters</b> can be used by pressing on the little down-pointing arrow next to the interested category. The two <b>checkboxes</b> can be selected/deselected just by clicking on the white little square 

Under every card there is a <b>heart-shaped</b> little icon that the user can press in order to flag the card as <b>favourite</b>. <br>
If the user wants more informations about a specific card  such like description or moves they can simply press on it.<br><br>
The added information in the detailed view is the following:
```
- Card name
- Card set
- Pokedex number
- Type
- Typings
- Weakness/resistance
- Pokemon HP
- Form (base/evolution)
- Retreat cost
- Release date
- Artist
- Abilities and moves description
```
## Deck Builder ##

The `deck builder` page is accesible for <b>logged user only</b>, in this page you can create and modify decks. The page is divided in two halvs:
```
- the left part shows the cards in the deck you are currently creating/modifing, with a textbox and a button above them so that you can rename and save your deck.

- the right part's purpose is that the user can find a card by its name, to then put it in the deck. The user can research writing the card name on the research bar and with the 'search' button. The research can also be easier through the use of <a>filters button</a>. The section below shows the user all the cards that are related to the searched card (evolutions and/or pre-evolutions). The user can add a card they want in the deck by dragging it in the left section, where all the other cards are.
```
The last `deck-builder` page feature is the test-hand: the user can test the <b>first hand</b> of a game by shuffling 7 cards of the deck (the cards that the player gets on the first turn)
## Deck Page ##

The deck page, besides the usual `navbar`, shows all the decks that the user has created before and it is able to tell if the deck is legal and can be played in official tournaments. If not, the user will be adviced with a <b>little red alert symbol</b>. This symbol is a hover, so that the user can see what rules the deck is breaking just by passing the mouse on it.
If the user does not know the rules, they can check the `Regulation Page`.<br><br>
At the top of the page there are three buttons and a searchbar where the user can:
```
- create a new deck using the 'new' button
- <b>modify</b> an existing deck using the 'edit' button
- search an existing deck using the searchbar and the 'search' button
```
## Series & Sets ##

The `series & sets` page is a very simple display of all the Pokemon card sets, where the user can find a card by knowing the set. The page is composed by six sections (one for each generation) and by clicking  on one of them the user can access all the sets that are part of the specified series (they will be divided in sections too), and then the user will be able to access all the cards of the set he chose.

## Top Cards ##

The `top cards` page is an ordered list of the most used cards, from the most used to the least. The page shows the card image with the pokemon name and the number of decks his card is found.
<br><br>
This page also has the normal search function with the `card filters`.

## Regulation ##

The `regulation page` is a paragraph where the basic rules used in pokemon tournaments are explained. The user can find rules about:
```
- Number of cards in the deck
- Limit for same cards
- Other limitations
- V-Uninon specific rules
- Regular pokemon rules
```
At the bottom of the page there is a <a>link</a> that brings to the complete regulation.