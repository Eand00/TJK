# TJK (The Java Kingdom)

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-green) ![Maven](https://img.shields.io/badge/Maven-3.6.3-orange)

## Table of Contents
- [Team](#team)
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup Instructions](#setup-instructions)

## TEAM

[Aliberti Alessandro](https://github.com/alealiberti) | [Avdiu Eand](https://github.com/Eand00) | [Capra Alessandro](https://github.com/SonoBruttoma2004) | [Giacometti Alessio](https://github.com/ggiaco-lab) | [Magosso Matteo](https://github.com/mattemagosso) | [Scanu Niccolò](https://github.com/Nickooooss)

## Overview

This project is a web application that serves as a card management system for the Pokémon card game. It features a backend built with Spring Boot, a static frontend, and a MySQL database for data persistence. The application allows users to create, manage, and interact with decks of cards, as well as manage user accounts and authentication.

**Key components include**:
- A backend using Spring Boot and MariaDB for data persistence
- A static frontend for user interactions
- Secure user authentication and session management

## Features

- **User Management**: 
  - Register, log in, update profile, and delete accounts.
  - Secure authentication with Spring Security.

- **Collection Management**: 
  - Add, edit, or remove Pokémon cards from your collection.
  - View detailed card stats.

- **Deck Management**: 
  - Create personalized decks by adding cards from your collection.
  - Remove or update cards in existing decks.
  - Validate decks according to Pokémon game rules, ensuring legality before gameplay.

- **Database**: 
  - MariaDB is used for robust, scalable data storage of user profiles, card collections, and decks.


## Technology Stack

- **Backend**: 
  - **Java 17**: The core programming language for backend logic.
  - **Spring Boot 3.3.4**: Provides a simplified, powerful framework for building the backend REST API.
  - **Spring Security**: Ensures secure login, authentication, and role-based access control.

- **Frontend**: 
  - **HTML, CSS, JavaScript**: Used to create a simple, responsive, and interactive web UI.

- **Database**: 
  - **MariaDB**: Chosen for its compatibility with MySQL, it stores user data, card details, and deck configurations.

- **Build Tool**: 
  - **Maven**: Manages project dependencies and builds processes for the Java backend.

## Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

Before starting, ensure that you have the following installed on your system:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MariaDB Server](https://mariadb.org/download/)

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Eand00/TJK.git
   cd TJK
   ```
2. **Set Up the Database**  
   Start your MariaDB server.
   Create a new database for the project:
   ```sql
   CREATE DATABASE master_trainer;
   ```
   Import `master_trainter.sql` provided in the Master_Trainer_DB directory to the database you just created  to set up your tables, all the cards and some testing data.  
   **For more information on the Database and its Setup ->** [Database](./Master_Trainer_DB/UserManual.md)

3. **Configure the Application**   
   Open the application.properties file in Master_Trainer/src/main/resources and update the database credentials if necessary.
   Update the application.properties file located in `Master_Traintersrc/src/main/resources` with your MariaDB credentials if needed.  

   Default:
   ```java
   spring.datasource.url=jdbc:mariadb://localhost:3306/master_trainer
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=validate
   server.port=1699
   ``` 

4. **Build and Run the Application**  
   Use Maven to build and run the project:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at http://localhost:1699.  
   **For more information on the API and its Setup ->** [API](./Master_Trainer/UsersManual.md)

5. **Frontend**  
   To reach the homepage of our frontend you need to go to Master_Trainer_Frontend/html/{your prefered language}/home.html from there you can explore on your own and test our intuitive design or click [here](Master_Trainer_Frontend/UserManual.md) for more detailed information on our Frontend.
