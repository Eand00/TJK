# TJK(The Java Kingdom)

## TEAM

[Aliberti Alessandro](https://github.com/alealiberti)  | [Avdiu Eand](https://github.com/Eand00) | [Capra Alessandro](https://github.com/SonoBruttoma2004) | [Giacometti Alessio](https://github.com/ggiaco-lab) | [Magosso Matteo](https://github.com/mattemagosso)  | [Scanu Niccolò](https://github.com/Nickooooss)

## Overview

This project is a web application that serves as a card management system for the Pokemon card game. It features a backend built with Spring Boot, a static frontend, and a MySQL database for data persistence. The application allows users to create, manage, and interact with decks of cards, as well as manage user accounts and authentication.

## Features

- **User Management**: Create, update, and delete user accounts.
- **Collection Management**: View, add, update and remove cards to the collection .
- **Deck Management**: Create decks, add/remove cards, and validate deck legality.
- **Static Frontend**: A responsive frontend for user interaction.
- **Database**: Uses MariaDB for data storage.

## Technology Stack

- **Backend**: 
  - Java 17
  - Spring Boot 3.3.4
  - Spring Security for authentication and authorization
- **Frontend**: 
  - HTML, CSS, JavaScript
- **Database**: 
  - MariaDB
- **Build Tool**: Maven

## Getting Started

### Prerequisites

Before running the application, ensure you have the following installed:

- Java JDK 17
- Maven
- MariaDB Server

### Setup Instructions

1. **Clone the Repository**

  ```bash
  git clone https://github.com/Eand00/TJK.git
  ```

2. **Set Up the Database**

  Start your MariaDB server.

  Create a new database for the project:
  ```sql
  CREATE DATABASE card_management_db;
  ```
  Run the SQL script `master_trainter.sql` provided in the Master_Trainer_DB directory to set up your tables, all the cards and some testing data.  

**For more information on the Database and its Setup ->** [Database](./Master_Trainer_DB/UserManual.md)  


3. **Configure the Application**  
Update the application.properties file located in `Master_Traintersrc/src/main/resources` with your MariaDB credentials if needed.  

Default:
  ```java
  spring.datasource.url=jdbc:mariadb://localhost:3306/master_trainer
  spring.datasource.username=root
  spring.datasource.password=
  spring.jpa.hibernate.ddl-auto=validate
  ``` 
**For more information on the API and its Setup ->** [API](./Master_Trainer/UsersManual.md)  