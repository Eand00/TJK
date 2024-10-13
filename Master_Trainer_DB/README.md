# Master Trainer DB

Here is a brief description about the database, how it is created and how the different tables interacts between them. To use the database, just import the [SQL file](./master_trainer.sql) in 
your MariaDB client.


## Sections

+ [Creation of the database](#creation-of-the-database)
+ [Creation of the tables](#creation-of-the-tables)
+ [Data dump](#data-dump)


## Creation of the database

At the beginning of the file there are multiple lines to create (if necessary) and use the `master_trainer` database.


## Creation of the tables

After that, there is a part of the code that creates the 5 following tables in the database.

+ `pokemoncards`: the table containing all the Pokemon cards records.
+ `userslogin`: the table containing all the users records.
+ `decks`: the table containing the various decks records. This table is linked to the tables `pokemoncards` and `userslogin`.
+ `decks_cards`: the table containing all the cards which are in the different decks. This table is linked to the tables `pokemoncards` and `decks`.
+ `collections`: the table containing all the cards that the users own and if their cards are marked as favourite or not. This table is linked to the tables `pokemoncards` and `userslogin`.

Then there is the part that creates the primary, foreign and unique keys to the tables and for the numerical primary keys it gives them the auto increment option. After that, the constrants between the tables are made. 


## Data dump

In the end, there is the part of the code that inserts records in all the tables. Since they are thousands of lines, here is a list of links to easily get to the different parts of the data dump:

+ [Data dump for the table `userslogin`](./master_trainer.sql#L200)
+ [Data dump for the table `pokemoncards`](./master_trainer.sql#L208)
<!-- + [Data dump for the table `decks`](./master_trainer.sql#L17715) -->
+ [Data dump for the table `collections`](./master_trainer.sql#L17693)
<!-- + [Data dump for the table `decks_cards`](./master_trainer.sql#L17767) -->
