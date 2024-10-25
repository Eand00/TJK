# Master Trainer DB

Here is a brief description about the database, how it is created and how the different tables interacts between them. To use the database, go into your `MariaDB` client and then create a DB called `master_trainer`. After that, you just need to import the [Master Trainer SQL file](./master_trainer.sql) in the DB you have created.

## Sections

- [Versions](#versions)
- [Creation of the tables](#creation-of-the-tables)
- [Tables fields](#tables-fields-and-constraints)
- [References to the code](#references-to-the-code)

## Versions

Here are the version used in the project:

- `MariaDB` (Server) version: 10.4.28-MariaDB
- `phpMyAdmin` (Client) version: 5.2.1

## Creation of the tables

These are the 5 tables created in the database (more details in the next section):

- `pokemoncards`: the table containing all the Pokemon cards records.
- `userslogin`: the table containing all the users records.
- `decks`: the table containing the various decks records.
- `decks_cards`: the table containing all the cards which are in the different decks.
- `collections`: the table containing all the cards that the users own.

## Tables fields and constraints

- `pokemoncards`:

  - `id_card` **\[PK\]** varchar(50)
  - `set_name` varchar(255)
  - `series` varchar(255)
  - `publisher` varchar(255)
  - `generation` varchar(255)
  - `release_date` varchar(255)
  - `artist` varchar(255), _nullable_
  - `name_card` varchar(255)
  - `set_num` varchar(255)
  - `types_card` varchar(255), _nullable_
  - `supertype` varchar(255), _nullable_
  - `subtypes` varchar(255)
  - `level_card` varchar(255), _nullable_
  - `hp` varchar(255), _nullable_
  - `evolves_from` varchar(255), _nullable_
  - `evolves_to` varchar(255), _nullable_
  - `abilities` text, _nullable_
  - `attacks` text, _nullable_
  - `weaknesses` varchar(255), _nullable_
  - `retreat_cost` varchar(255), _nullable_
  - `converted` varchar(255), _nullable_
  - `rarity` varchar(255), _nullable_
  - `flavour_text` text, _nullable_
  - `national_pokedex_numbers` varchar(255), _nullable_
  - `legalities` varchar(255)
  - `resistances` varchar(255), _nullable_
  - `rules` text, _nullable_
  - `regulation_mark` varchar(255), _nullable_
  - `ancient_trait` text, _nullable_
  - `img` text

- `userslogin`:

  - `id_user` **\[PK\]** int(11)
  - `username` **\[Unique Key\]** varchar(255)
  - `private_profile` tinyint(1)
  - `first_name` varchar(255), _nullable_
  - `surname` varchar(255), _nullable_
  - `password_hash` varchar(255)
  - `role` varchar(50)

- `decks`:

  - `id_deck` **\[PK\]** int(11)
  - `id_user` **\[FK\]** int(11), references to `id_user` in the table `userslogin`
  - `cover_card` **\[FK\]** varchar(255), references to `id_card` in the table `pokemoncards`
  - `deck_name` varchar(255)
  - `format` varchar(255)
  - `legal` tinyint(1)
  - `is_private` tinyint(1)

- `decks_cards`:

  - `id_card` **\[PK\]** **\[FK\]** varchar(255), references to `id_card` in the table `pokemoncards`
  - `id_deck` **\[PK\]** **\[FK\]** int(11), references to `id_deck` in the table `decks`
  - `quantity` int(11)

- `collections`:

  - `id_card` **\[PK\]** **\[FK\]** varchar(255), references to `id_card` in the table `pokemoncards`
  - `id_user` **\[PK\]** **\[FK\]** int(11), references to `id_user` in the table `userslogin`
  - `favourite` tinyint(1), _nullable_
  - `quantity` int(11), _nullable_

## References to the code

Since they are thousands of lines, here is a list of links to easily get to the different parts of the code:

<!-- TODO update links when the db is finished -->

- [Creation and data dump of the table `collections`](./master_trainer.sql#L27)
- [Creation and data dump of the table `decks`](./master_trainer.sql#L61)
- [Creation and data dump of the table `decks_cards`](./master_trainer.sql#L107)
- [Creation and data dump of the table `pokemoncards`](./master_trainer.sql#L214)
- [Creation and data dump of the table `userslogin`](./master_trainer.sql#L17736)
- [Indexes, auto increment and constraints of the tables](./master_trainer.sql#L17771)
