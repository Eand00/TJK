# Master Trainer DB
Brief introduction


## Sections

+ [Creation of the database](#creation-of-the-database)
+ [Creation of the tables](#creation-of-the-tables)
+ [Data dump](#data-dump)


## Creation of the database

At the beginning of the file ([lines 1-27](./master_trainer.sql#L1)) there are multiple lines to create (if necessary) and use the `master_trainer` database.


## Creation of the tables

After that, there is a part of the SQL code that creates the 5 following tables in the database ([lines 29-210](./master_trainer.sql#L31)).

+ `pokemoncards`: the table containing all the Pokemon cards records.
+ `userslogin`: the table containing all the users records.
+ `decks`: the table containing the various decks records. This table is linked to the tables `pokemoncards` and `userslogin`.
+ `decks_cards`: the table containing all the cards which are in the different decks. This table is linked to the tables `pokemoncards` and `decks`.
+ `collections`: the table containing all the cards that the users own and if their cards are marked as favourite or not. This table is linked to the tables `pokemoncards` and `userslogin`.

Then there is the part that creates the primary, foreign and unique keys to the tables and for the numerical primary keys it gives them the auto increment option. After that, the constrants between the tables are made. 


## Data dump

[Start dumping data](./master_trainer.sql#L207)


#### References to the code:
+ [Dump for the table `userslogin`](./master_trainer.sql#L211)
+ [Dump for the table `cards`](./master_trainer.sql#L221)
+ [Dump for the table `decks`](./master_trainer.sql#L17707)
+ [Dump for the table `collections`](./master_trainer.sql#L17717)
+ [Dump for the table `decks_cards`](./master_trainer.sql#L17759)


<!-- Data dump -->
<!-- Insert introduction -->
<!-- Insert links to the code lines -->
