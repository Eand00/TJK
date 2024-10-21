# Master Trainer DB

Here is a brief description about the database, how it is created and how the different tables interacts between them. To use the database, go into your `MariaDB` client and then create a DB called `master_trainer`. After that, you just need to import the [Master Trainer SQL file](./master_trainer.sql) in the DB you have created.

## Sections

- [Versions](#versions)
- [Creation of the tables](#creation-of-the-tables)
- [Tables fields](#tables-fields-and-constraints)
- [Data dump](#data-dump)

## Versions

Here are the version used in the project:

- `MariaDB` (Server) version: 10.4.28-MariaDB
- `phpMyAdmin` (Client) version: 5.2.1

## Creation of the tables

These are the 5 tables created in the database:

- `pokemoncards`: the table containing all the Pokemon cards records.
- `userslogin`: the table containing all the users records.
- `decks`: the table containing the various decks records.
<!-- This table is linked to the tables `pokemoncards` and `userslogin`. -->
- `decks_cards`: the table containing all the cards which are in the different decks.
<!-- This table is linked to the tables `pokemoncards` and `decks`. -->
- `collections`: the table containing all the cards that the users own.
  <!-- and if their cards are marked as favourite or not.  -->
  <!-- This table is linked to the tables `pokemoncards` and `userslogin`. -->

## Tables fields and constraints

<!-- inserire campi tabelle, PK FK UK -->
<!-- breve descrizione con link al codice -->

## Data dump

<!-- aggiornare linee di codice con db aggiornato -->

In the end, there is the part of the code that inserts records in all the tables. Since they are thousands of lines, here is a list of links to easily get to the different parts of the data dump:

- [Data dump for the table `userslogin`](./master_trainer.sql#L200)
- [Data dump for the table `pokemoncards`](./master_trainer.sql#L208)
<!-- + [Data dump for the table `decks`](./master_trainer.sql#L17715) -->
- [Data dump for the table `collections`](./master_trainer.sql#L17693)
<!-- + [Data dump for the table `decks_cards`](./master_trainer.sql#L17767) -->
