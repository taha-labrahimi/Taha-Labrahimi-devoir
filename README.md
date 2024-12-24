# Projet Microservices - Gestion des Commandes et Produits

Bienvenue dans le projet de gestion des commandes et des produits implémenté en architecture microservices avec Spring Boot et d'autres outils pertinents.

## Table des Matières
- [Description](#description)
- [Structure du Projet](#structure-du-projet)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Fonctionnalités](#fonctionnalités)
---

## Description

Ce projet est une implémentation basée sur une architecture microservices utilisant Spring Boot. Les microservices principaux incluent :

- **Microservice-Commandes** : Gestion complète des commandes avec des opérations CRUD.
- **Microservice-Produits** : Gestion des produits associés aux commandes.
- **Eureka Server** : Service de registre pour la découverte des services.
- **Config Server** : Serveur central pour la configuration des microservices.
- **API Gateway** : Point d'accès unique à l'ensemble des microservices.

---

## Structure du Projet

Voici les principaux dossiers et microservices :

- `commandes/` : Gestion des commandes.
- `microservice-produit/` : Gestion des produits.
- `eureka-server/` : Service de registre Eureka.
- `configServer/` : Serveur de configuration.
- `new-config-repo/` : Configuration externe des microservices.

---

## Prérequis

- **Java 17+**
- **Maven**
- **Git**
- Un IDE comme IntelliJ IDEA ou Eclipse.

---

## Installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/votre-utilisateur/Taha-Labrahimi-devoir.git
   cd Taha-Labrahimi-devoir
   ```

2. **Démarrer les services dans cet ordre** :
   - `eureka-server`
   - `configServer`
   - `microservice-produit`
   - `commandes`

3. **Démarrage** :
   - Pour chaque microservice, utilisez :
     ```bash
     mvn spring-boot:run
     ```

---

## Fonctionnalités

### 1. **Microservice Commandes**
- **CRUD** complet pour les commandes :
  - Créer une commande.
  - Lire toutes les commandes ou une commande par ID.
  - Mettre à jour une commande.
  - Supprimer une commande.

### 2. **Eureka Server**
- Registre pour la découverte des microservices.

### 3. **API Gateway**
- Fournit un accès unique et un routage centralisé pour les microservices.
