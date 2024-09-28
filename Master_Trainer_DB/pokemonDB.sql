-- creation of the db. if the db already exist, comment this line
CREATE DATABASE PokemonDB
-- using the db, if you already have the db, uncomment the line
-- USE PokemonDB
-- GO

-- creation of the table Card
CREATE TABLE PokemonCard(
    id_card varchar not null PRIMARY KEY,     -- Primary key
    set_name varchar not null,
    series varchar not null,
    publisher varchar not null,
    generation varchar not null,
    release_date date not null,
    artist varchar,
    name_card varchar not null,
    set_num int not null,
    types_card varchar,
    supertype varchar,
    subtypes varchar not null,
    level_card int,
    hp int,
    evolvesFrom varchar,
    evolvesTo varchar,
    abilities varchar,
    attacks varchar,
    weakness varchar,
    retreatCost varchar,
    converted int,
    rarity varchar,
    flavorText varchar,
    natiolanPokedexNumbers varchar,
    legalities varchar not null,
    resistances varchar,
    rules varchar,
    regulationMark varchar,
    ancientTrait varchar,
    img varchar not null
);

-- creation of the table User
CREATE TABLE UserLogin(
    id_user int not null PRIMARY KEY,       -- primary key
    private_profile boolean not null,
    first_name varchar,
    surname varchar,
    username varchar not null,
    passw varchar not null
);

-- creation of the table Collection
CREATE TABLE Collection(
	id_card varchar not null,
	id_user int not null,
	favourite boolean,
	quantity int,
	FOREIGN KEY (id_card) REFERENCES PokemonCard(id_card),
	FOREIGN KEY (id_user) REFERENCES UserLogin(id_user),
	PRIMARY KEY (id_card, id_user)
);
