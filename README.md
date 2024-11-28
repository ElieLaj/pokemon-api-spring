# Pokémon API

Bienvenue sur l'API Spring Boot pour la gestion des Pokémons ! Cette API sécurisée permet d'interagir avec une base de données PostgreSQL pour récupérer des informations sur différents Pokémons.

## Déploiement

L'API est déployée et accessible à l'adresse suivante :  
[https://pokemon-api-spring.onrender.com/api/v1](https://pokemon-api-spring.onrender.com/api/v1)

## Fonctionnalités

- **Récupérer la liste des Pokémons**  
  Endpoint : `/pokemons`  
  Méthode : `GET`

- **Récupérer un Pokémon par ID**  
  Endpoint : `/pokemons/{id}`  
  Méthode : `GET`

- **Ajouter un Pokémon**  
  Endpoint : `/pokemons`  
  Méthode : `POST`

- **Mettre à jour un Pokémon**  
  Endpoint : `/pokemons/{id}`  
  Méthode : `PUT`

- **Supprimer un Pokémon**  
  Endpoint : `/pokemons/{id}`  
  Méthode : `DELETE`

## Sécurité

L'API utilise une couche de sécurité pour protéger les accès aux données. Seuls les utilisateurs authentifiés peuvent interagir avec les endpoints protégés.

## Technologies utilisées

- **Spring Boot** pour le développement de l'API
- **PostgreSQL** comme base de données pour stocker les informations des Pokémons
- **Spring Security** pour l'implémentation de la sécurité

## Installation et configuration locale

1. Clonez ce repository :
   ```bash
   git clone https://github.com/votre-utilisateur/pokemon-api-spring.git
